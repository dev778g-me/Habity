package com.dev.habity.Model.Repo

import android.content.Context
import com.dev.habity.Model.Database.CompletionDao
import com.dev.habity.Model.Database.Habit
import com.dev.habity.Model.Database.HabitDao
import com.dev.habity.Model.Database.IntervalDao
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class HabitRepo (
    private val context: Context,
    private val habitDao: HabitDao,
    private val intervalDao: IntervalDao,
    private val completionDao: CompletionDao
) {
    suspend fun fetchDb() = withContext(Dispatchers.IO) {
          habitDao.getAllHabits()
    }

    // function to insert a habit
    suspend fun insertHabit(habit: Habit) = withContext(Dispatchers.IO) {
        habitDao.insertHabit(habit = habit)
    }

    // function to delete one habit
    suspend fun deleteHabit(habit: Habit) = withContext(Dispatchers.IO) {
        habitDao.deleteHabit(habit = habit)
    }




}