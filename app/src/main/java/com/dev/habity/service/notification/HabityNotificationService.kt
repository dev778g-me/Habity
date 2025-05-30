package com.dev.habity.service.notification

import android.app.Notification
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.Build
import android.service.notification.NotificationListenerService
import androidx.core.app.NotificationCompat
import com.dev.habity.MainActivity
import com.dev.habity.R
import dagger.hilt.android.qualifiers.ApplicationContext

class HabityNotificationService(
    @ApplicationContext context: Context
) {

    private val notificationManager = context.getSystemService(Context.NOTIFICATION_SERVICE) as  NotificationManager

    fun showNotification(context: Context){
        val intent = Intent(context, MainActivity::class.java)
        val pendingIntent = PendingIntent.getActivity(
            context,
            1,
            intent,
            PendingIntent.FLAG_IMMUTABLE
        )
        val notification = NotificationCompat.Builder(context,HABITYNOTIFICATION_ID)
            .setSmallIcon(R.drawable.monochrome)
            .setContentText("Habity Notification")
            .setContentTitle("Habity")
            .setContentInfo("First Notification")
            .setContentIntent(pendingIntent)
            .build()

        notificationManager.notify(
            1,
            notification
        )

    }

    companion object{
      const  val HABITYNOTIFICATION_ID = "habity_notification_id"

    }
}