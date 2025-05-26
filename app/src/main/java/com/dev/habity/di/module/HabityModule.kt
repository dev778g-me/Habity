package com.dev.habity.di.module

import android.content.Context
import androidx.room.Room
import com.dev.habity.Model.Database.HabitDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton
import kotlin.concurrent.Volatile

@InstallIn(SingletonComponent::class)
@Module
class HabityModule(

) {

    @Singleton
    @Provides
    fun provideHabitDatabase(
        @ApplicationContext context: Context
    ) : HabitDatabase {
        return Room.databaseBuilder(
            context,
            HabitDatabase::class.java,
            "habit_database"
        ).build()

    }


}