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
}