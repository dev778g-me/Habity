package com.dev.habity.View.HabityWidget

import com.dev.habity.Model.Repo.HabitRepo
import dagger.hilt.EntryPoint
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@EntryPoint
@InstallIn(SingletonComponent::class)
interface HabitWidetEntryPoint {
    fun habitRepository() : HabitRepo

}