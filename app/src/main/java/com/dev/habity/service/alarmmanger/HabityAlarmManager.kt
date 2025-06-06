package com.dev.habity.service.alarmmanger

import android.app.AlarmManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.provider.CalendarContract.CalendarEntity
import android.util.Log
import com.dev.habity.Model.Database.Habit
import dagger.hilt.android.qualifiers.ApplicationContext
import java.time.LocalTime
import java.util.Calendar
import javax.inject.Inject

class HabityAlarmManager @Inject constructor(
    @ApplicationContext context: Context
) { 
    
    private val alarmManager = context.getSystemService(Context.ALARM_SERVICE) as AlarmManager



    fun scheduleNotification(week: List<Int>, time: LocalTime, habitId: Long,context: Context) {

        println("the alarm manager code has been started ")
        Log.d("ALARMy","started alarn")
        for (day in week){
             val intent = Intent(context, HabityAlarmManagerReceiver::class.java)

            val requestCode = (habitId.toInt() * 10 + day)
            val pendingIntent: PendingIntent = PendingIntent.getBroadcast(
                context,
                requestCode,
                intent,
                PendingIntent.FLAG_UPDATE_CURRENT or PendingIntent.FLAG_IMMUTABLE

            )
           println("the alarm manager started")
            // creating the actual timeStamp
            val calendar = Calendar.getInstance().apply {
                timeInMillis = System.currentTimeMillis()
                set(Calendar.DAY_OF_WEEK,day)
                set(Calendar.HOUR_OF_DAY,time.hour)
                set(Calendar.MINUTE,time.minute)
                set(Calendar.SECOND,0)
                set(Calendar.MILLISECOND,0)

                if (before(Calendar.getInstance())){
                    add(Calendar.WEEK_OF_YEAR,1)
                }
            }

            // scheduling the alarm manager << >>
            alarmManager.setAndAllowWhileIdle(
                AlarmManager.RTC_WAKEUP,
                calendar.timeInMillis,
                pendingIntent
            )
        }
        Log.d("ALARMy","ended alarn")

        }
    }
