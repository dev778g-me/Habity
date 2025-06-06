package com.dev.habity.service.alarmmanger

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import androidx.work.ExistingWorkPolicy
import androidx.work.OneTimeWorkRequest
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.WorkManager

class HabityBootManager : BroadcastReceiver(){
    override fun onReceive(context: Context, intent: Intent?) {
        if (intent?.action == Intent.ACTION_BOOT_COMPLETED){
           val work = OneTimeWorkRequestBuilder<RescheduleAlarmService>().build()
            WorkManager.getInstance(context).enqueueUniqueWork(
                "reschedule_alarm_after_boot",
                ExistingWorkPolicy.REPLACE,
                work
            )
        }
    }
}