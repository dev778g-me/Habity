package com.dev.habity.di

import android.app.Application
import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.os.Build
import com.dev.habity.service.notification.HabityNotificationService
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class HabityApplication(

) : Application() {


    override fun onCreate() {
        super.onCreate()
      createNotificationChannel()
    }
    private fun createNotificationChannel(){
         val channel = NotificationChannel(
             HabityNotificationService.HABITYNOTIFICATION_ID,
             "Habity Nofication",
             NotificationManager.IMPORTANCE_HIGH
         )
        channel.description= "Channel for Habity Notifications"

        val notificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

        notificationManager.createNotificationChannel(channel)
    }
}