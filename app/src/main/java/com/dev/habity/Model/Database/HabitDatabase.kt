package com.dev.habity.Model.Database

import android.content.Context
import androidx.compose.ui.graphics.GraphicsContext
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase


@Database(entities = [Habit::class, Completion::class, IntervalEntity::class], version = 1)
abstract class HabitDatabase : RoomDatabase(){
    abstract fun HabitDao() : HabitDao
    abstract fun CompletionDao() : CompletionDao
    abstract fun IntervalDao(): IntervalDao

    companion object{
        @Volatile
       private var INSTANCE: HabitDatabase? = null
        fun getDatabase(context: Context) : HabitDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    HabitDatabase::class.java,
                    "habit_database"
                ).build()
                INSTANCE = instance
                INSTANCE ?: throw IllegalStateException("Database instance is null")
            }
        }
    }
}