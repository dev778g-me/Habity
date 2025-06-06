package com.dev.habity.service.alarmmanger

import android.app.IntentService
import android.content.Context
import android.content.Intent
import androidx.hilt.work.HiltWorker
import androidx.room.CoroutinesRoom
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import com.dev.habity.Model.Database.HabitDao
import com.dev.habity.Model.Database.HabitDatabase
import com.dev.habity.Model.Repo.HabitRepo
import dagger.assisted.Assisted
import dagger.assisted.AssistedInject


@HiltWorker
class RescheduleAlarmService @AssistedInject constructor(
    @Assisted private val appContext: Context,
    @Assisted private val parameters: WorkerParameters,
    private val habitDao: HabitDao
) : CoroutineWorker(
    appContext = appContext,
    params = parameters
) {
    override suspend fun doWork(): Result {
         println("the work manager started")
        val habits = habitDao.getHabitsForWorkManager()

        val alarmManager = HabityAlarmManager(
            context = appContext
        )
        try {
            for (habit in habits) {
                alarmManager.scheduleNotification(
                    week = habit.notificationDays,
                    time = habit.notificationTime,
                    habitId = habit.id,
                    context = appContext
                )
            }
        } catch (e: Exception) {
          println(e.message.toString())
        }
        return Result.success()
    }
}