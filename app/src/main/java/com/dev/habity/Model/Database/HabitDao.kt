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
     fun getAllHabits(): Flow<List<Habit>>

    @Upsert()
    suspend fun insertHabit(habit: Habit)

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
    fun getCompletionForHabit(habitId: String) : Flow<List<Completion>>

    //get completion for a specific date
    @Query("SELECT * FROM completions WHERE habitId = :habitId AND date =:date LIMIT 1")
    suspend fun getCompletionForDate(habitId: String,date: Long) : Completion ?

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