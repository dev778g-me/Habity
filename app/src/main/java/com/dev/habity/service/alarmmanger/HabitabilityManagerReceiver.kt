package com.dev.habity.service.alarmmanger

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log
import com.dev.habity.service.notification.HabityNotificationService

class HabityAlarmManagerReceiver () : BroadcastReceiver(){


    override fun onReceive(context: Context?, intent: Intent?) {

        println("started the nyt")
        Log.d("ALARMy", "onReceive: revieved brodcast")
            HabityNotificationService(
                context = context!!
            ).showNotification(
                message = "U haven't Completed Your Habit ",
                context = context
            )
    }
}