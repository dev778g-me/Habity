package com.dev.habity.di.module

import android.content.Context
import androidx.work.ListenableWorker
import androidx.work.WorkerFactory
import androidx.work.WorkerParameters
import javax.inject.Inject

class HabityWorkerFactory @Inject constructor(
    private val workerFactory: WorkerFactory
): WorkerFactory(){
    override fun createWorker(
        appContext: Context,
        workerClassName: String,
        workerParameters: WorkerParameters
    ): ListenableWorker? {
        return workerFactory.createWorker(appContext, workerClassName,workerParameters)
    }
}