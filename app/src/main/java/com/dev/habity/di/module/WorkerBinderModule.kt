package com.dev.habity.di.module

import androidx.work.WorkerFactory
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class WorkerBinderModule {


    @Binds
    abstract fun binderWorkerFactory(
        factory: WorkerFactory
    ): WorkerFactory

}