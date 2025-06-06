package com.dev.habity.View.HabityWidget

import android.content.Context
import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.toUpperCase
import androidx.compose.ui.unit.DpSize
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.glance.GlanceId
import androidx.glance.GlanceModifier
import androidx.glance.GlanceTheme
import androidx.glance.Image
import androidx.glance.ImageProvider
import androidx.glance.LocalSize
import androidx.glance.appwidget.GlanceAppWidget
import androidx.glance.appwidget.LocalAppWidgetOptions
import androidx.glance.appwidget.SizeMode
import androidx.glance.appwidget.cornerRadius
import androidx.glance.appwidget.lazy.GridCells
import androidx.glance.appwidget.lazy.LazyVerticalGrid
import androidx.glance.appwidget.provideContent
import androidx.glance.background
import androidx.glance.layout.Alignment
import androidx.glance.layout.Box
import androidx.glance.layout.Column
import androidx.glance.layout.Row
import androidx.glance.layout.Spacer
import androidx.glance.layout.fillMaxSize
import androidx.glance.layout.fillMaxWidth
import androidx.glance.layout.height
import androidx.glance.layout.padding
import androidx.glance.layout.size
import androidx.glance.layout.width
import androidx.glance.state.GlanceStateDefinition
import androidx.glance.text.FontFamily
import androidx.glance.text.FontStyle
import androidx.glance.text.FontWeight
import androidx.glance.text.Text
import androidx.glance.text.TextStyle
import com.dev.habity.Model.Database.Habit
import com.dev.habity.R
import dagger.hilt.android.EntryPointAccessors
import java.time.LocalDate
import java.util.Calendar

class HabityWidget  : GlanceAppWidget(){





    companion object {
        private val SMALL_SQUARE = DpSize(100.dp, 100.dp)
        private val HORIZONTAL_RECTANGLE = DpSize(250.dp, 100.dp)
        private val BIG_SQUARE = DpSize(250.dp, 250.dp)
    }

    override val sizeMode = SizeMode.Responsive(
        setOf(
            SMALL_SQUARE,
            HORIZONTAL_RECTANGLE,
            BIG_SQUARE
        )
    )



    @RequiresApi(Build.VERSION_CODES.S)
    override suspend fun provideGlance(
        context: Context,
        id: GlanceId
    ) {
        val appContext = context.applicationContext
        val entryPoint = EntryPointAccessors.fromApplication(
            context = appContext,
            HabitWidetEntryPoint::class.java
        )

        val habitRepo= entryPoint.habitRepository()

        val habit = habitRepo.fetchHabitById(1)

         provideContent {
            HeatMapWidget(
                habit = habit
            )
         }
    }

    @RequiresApi(Build.VERSION_CODES.S)
    @Composable
    fun HeatMapWidget(habit: Habit) {
        val calendar = Calendar.getInstance()
        val size = LocalSize.current
        val boxSize = 10.dp
        val spacing = 2.dp
        val maxColumns = (size.width / (boxSize + spacing)).toInt()
        val month = calendar.get(Calendar.MONTH) + 1 //
        val daysInMonth = calendar.getActualMaximum(Calendar.DAY_OF_MONTH)
        val width = size.width


        Box(
            modifier = GlanceModifier
                .fillMaxSize()
                .background(GlanceTheme.colors.widgetBackground)
        ) {
            Column(
                modifier = GlanceModifier
                    .fillMaxSize()
                    .padding(8.dp)
            ) {
                // Title with padding and color
                Text(
                    modifier = GlanceModifier.padding(start = 4.dp, bottom = 6.dp),
                    text = habit.title,
                    style = TextStyle(
                        color = GlanceTheme.colors.onPrimaryContainer,
                        fontSize = 13.sp,
                        fontWeight = FontWeight.Medium,
                        fontStyle = FontStyle.Normal
                    )
                )
              Row(
                  modifier = GlanceModifier
                      .fillMaxSize()
              ) {
                  if (HORIZONTAL_RECTANGLE == size){
                      val dayLabels = listOf("Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat")
                      Column {
                        dayLabels.forEach {
                            Text(
                                text = it,
                                style = TextStyle(
                                    fontSize = 6.sp,
                                    fontWeight = FontWeight.Normal,
                                    color = GlanceTheme.colors.secondary
                                )
                            )
                        }
                      }

                  }
                  Column(
                      modifier = GlanceModifier.fillMaxSize(),
                      horizontalAlignment = Alignment.Horizontal.CenterHorizontally
                  ) {
                      repeat(5) {
                          Row(
                              modifier = GlanceModifier.fillMaxWidth(),
                              horizontalAlignment = Alignment.Horizontal.CenterHorizontally
                          ) {
                              repeat(7){
                                  Box(
                                      modifier = GlanceModifier
                                          .padding(horizontal = 1.5.dp, vertical = 1.5.dp),

                                  ) {
                                      Box(
                                          modifier = GlanceModifier
                                              .height(8.dp)
                                              .width(13.dp)
                                              .cornerRadius(2.dp)
                                              .background(
                                                  if ((0..10).random() > 7)
                                                      GlanceTheme.colors.onPrimaryContainer
                                                  else
                                                      GlanceTheme.colors.inversePrimary

                                              )
                                      ) {  }
                                  }
                              }
                          }
                      }

                  }


              }


            }
        }
    }



}