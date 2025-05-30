package com.dev.habity.di.module

import android.content.Context
import androidx.room.Room
import com.dev.habity.Model.Database.CompletionDao
import com.dev.habity.Model.Database.HabitDao
import com.dev.habity.Model.Database.HabitDatabase
import com.dev.habity.Model.Repo.HabitRepo
import com.dev.habity.service.notification.HabityNotificationService
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
    // providing the habit database
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

    // providing the habit dao
    @Provides
    fun provideHabitDao(habitDatabase: HabitDatabase) : HabitDao{
        return habitDatabase.HabitDao()
    }


    // provides the completion habit dao
    @Provides
    fun provideCompletionsDao(habitDatabase: HabitDatabase) : CompletionDao {
        return habitDatabase.CompletionDao()
    }


    // provides the habit repository
    @Provides
    fun provideRepository(
        habitDao: HabitDao,
        completionDao: CompletionDao
    ) : HabitRepo {
        return HabitRepo(
            habitDao = habitDao,
            completionDao = completionDao
        )
    }

    // provides the notification service
    @Provides
    fun providesNotificationService (
        @ApplicationContext context: Context
    ) : HabityNotificationService {
        return HabityNotificationService(
            context = context
        )
    }

}