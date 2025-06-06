package com.dev.habity.Model.Repo

import android.content.Context
import androidx.compose.ui.input.pointer.PointerId
import androidx.lifecycle.LiveData
import com.dev.habity.Model.Database.Completion
import com.dev.habity.Model.Database.CompletionDao
import com.dev.habity.Model.Database.Habit
import com.dev.habity.Model.Database.HabitDao
import com.dev.habity.Model.Database.IntervalDao
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class HabitRepo @Inject constructor (
  private  val habitDao: HabitDao,
  private  val completionDao: CompletionDao

) {
    val allHabits: LiveData<List<Habit>> = habitDao.getAllHabits()

    //[ function of habits and habit dao] ----------------------------
    // function to get all habits
    suspend fun fetchDb() = withContext(Dispatchers.IO) {
          habitDao.getAllHabits()
    }

    suspend fun getHabitsForWorkManager() = withContext(Dispatchers.IO) {
        habitDao.getHabitsForWorkManager()
    }

    // function to get a single habit by the id
   suspend fun fetchHabitById(habitId: Long) : Habit {
     return habitDao.getHabitById(habitId = habitId)
    }

    // function to insert a habit
    suspend fun insertHabit(habit: Habit) : Long = withContext(Dispatchers.IO){
     return@withContext habitDao.insertHabit(habit = habit)
    }

    // function to delete one habit
    suspend fun deleteHabit(habit: Habit) = withContext(Dispatchers.IO) {
        habitDao.deleteHabit(habit = habit)
    }

    //[ function of habits and habit dao] ------------------------------

    // [ function of completions and completion dao]
    // function to get and fetch all the completions for a specific habits

   suspend fun fetchCompletionForWidget(habitId: Long, start: Long, end: Long): List<Completion>{
       return completionDao.getCompletionsBetween(
           habitId = habitId,
           start = start,
           end = end
       )
    }

    fun fetchCompletions(habitId: Long) : LiveData<List<Completion>>{
        return completionDao.getCompletionForHabit(
            habitId = habitId
        )
    }
    // function to insert a completion for a habit into the database
    suspend fun insertCompletions(completion: Completion) = withContext(Dispatchers.IO) {
        completionDao.insertCompletion(
            completion = completion
        )
    }


   suspend fun getLatestCompletion(habitId: Long) : Completion{
        return completionDao.getLatestCompletion(
            habitId = habitId
        )
    }

    suspend fun deleteLatestCompletion(completion: Completion) {
        completionDao.deleteCompletion(
            completion = completion
        )
    }


}