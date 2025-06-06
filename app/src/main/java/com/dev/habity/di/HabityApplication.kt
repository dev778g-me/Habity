package com.dev.habity.di

import android.app.Application
import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.os.Build
import android.util.Log
import androidx.hilt.work.HiltWorker
import androidx.hilt.work.HiltWorkerFactory
import androidx.work.Configuration
import androidx.work.ListenableWorker
import androidx.work.WorkerFactory
import androidx.work.WorkerParameters
import com.dev.habity.Model.Database.HabitDao
import com.dev.habity.service.alarmmanger.RescheduleAlarmService
import com.dev.habity.service.notification.HabityNotificationService
import dagger.Binds
import dagger.hilt.android.HiltAndroidApp
import javax.inject.Inject

@HiltAndroidApp
class HabityApplication(

) : Application(), Configuration.Provider {

    @Inject
    lateinit var workerFactory: HiltWorkerFactory

    override val workManagerConfiguration: Configuration
        get() = Configuration.Builder()
            .setMinimumLoggingLevel(
                loggingLevel = Log.DEBUG
            )
            .setWorkerFactory(workerFactory)
            .build()

    override fun onCreate() {
        super.onCreate()
      createNotificationChannel()
    }

    // function to create notification channel
    private fun createNotificationChannel(){
         val channel = NotificationChannel(
             HabityNotificationService.HABITYNOTIFICATION_ID,
             "Habity Nofication",
             NotificationManager.IMPORTANCE_HIGH
         )

        channel.description= "Habit Notification"

        val notificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

        notificationManager.createNotificationChannel(channel)
    }




    // function to schedule alarm after the boot completed
    fun reScheduleAlarm(){


    }
}



