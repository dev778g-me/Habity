package com.dev.habity.Model.Database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Index
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Upsert
import kotlinx.coroutines.flow.Flow
import java.sql.Date

@Dao
interface HabitDao {
    // Get all habits
     @Query("SELECT * FROM habits ORDER BY createdAt DESC")
     fun getAllHabits(): LiveData<List<Habit>>

     // get all habits for the work manager
     @Query("SELECT * FROM habits ORDER BY createdAt DESC")
     suspend fun getHabitsForWorkManager(): List<Habit>

     // get a particular habit by id
     @Query("SELECT * FROM habits WHERE id = :habitId LIMIT 1")
    suspend fun getHabitById(habitId: Long) : Habit

    @Upsert()
    suspend fun insertHabit(habit: Habit) : Long

    @Delete
    suspend fun deleteHabit(habit: Habit)

}


@Dao
interface CompletionDao{

    // Insert completion
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCompletion(completion: Completion)

    // Get all completions for a specific habit
    @Query("SELECT * FROM completions WHERE habitId = :habitId ORDER BY date DESC ")
    fun getCompletionForHabit(habitId: Long) : LiveData<List<Completion>>

    @Query("SELECT * FROM completions WHERE habitId = :habitId AND date BETWEEN :start AND :end")
     suspend fun getCompletionsBetween(habitId: Long, start: Long, end: Long): List<Completion>


    //get completion for a specific date
    @Query("SELECT * FROM completions WHERE habitId = :habitId AND date =:date LIMIT 1")
    suspend fun getCompletionForDate(habitId: Long,date: Long) : Completion ?


    // get the latest completion
    @Query("SELECT * FROM completions WHERE habitId =:habitId ORDER by date DESC LIMIT 1 ")
    fun getLatestCompletion(habitId: Long) : Completion
    // delete the latest completions


    //delete all the completions
    @Delete
    suspend fun deleteCompletion(completion: Completion)

    
}

@Dao
interface IntervalDao{
    //Insert Interval
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertInterval(interval: IntervalEntity)

    //get all interval by habit id
    @Query("SELECT * FROM intervals WHERE habitId = :habitId LIMIT 1")
    suspend fun getIntervalByHabitId(habitId: String) : IntervalEntity?

    //delete interval
    @Delete
    suspend fun deleteInterval(interval: IntervalEntity)
}