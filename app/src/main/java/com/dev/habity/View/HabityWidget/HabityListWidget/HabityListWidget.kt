package com.dev.habity.View.HabityWidget.HabityListWidget

import android.content.Context
import android.util.Log
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.datastore.preferences.core.Preferences
import androidx.glance.*
import androidx.glance.appwidget.*
import androidx.glance.appwidget.lazy.LazyColumn
import androidx.glance.appwidget.lazy.itemsIndexed
import androidx.glance.appwidget.provideContent
import androidx.glance.background
import androidx.glance.layout.*
import androidx.glance.state.GlanceStateDefinition
import androidx.glance.state.PreferencesGlanceStateDefinition
import androidx.glance.text.FontWeight
import androidx.glance.text.Text
import androidx.glance.text.TextStyle
import com.dev.habity.Model.Database.Completion
import com.dev.habity.Model.Database.Habit
import com.dev.habity.Model.Repo.HabitRepo
import com.dev.habity.View.HabityWidget.HabitWidetEntryPoint
import dagger.hilt.android.EntryPointAccessors
import kotlinx.coroutines.coroutineScope
import java.util.*

class HabityListWidget : GlanceAppWidget() {


    val calendar = Calendar.getInstance()
    fun Calendar.toMidnight(): Long {
        set(Calendar.HOUR_OF_DAY, 0)
        set(Calendar.MINUTE, 0)
        set(Calendar.SECOND, 0)
        set(Calendar.MILLISECOND, 0)
        return timeInMillis
    }

    fun Long.toMidnight(): Long {
        calendar.timeInMillis = this
        return calendar.toMidnight()
    }

    fun getCurrentWeekDays(): List<Long> {
        calendar.firstDayOfWeek = Calendar.SUNDAY
        calendar.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY)
        return List(7) {
            val dayMillis = calendar.toMidnight()
            calendar.add(Calendar.DAY_OF_MONTH, 1)
            dayMillis
        }
    }

    val weekDays = getCurrentWeekDays()

    override val stateDefinition: GlanceStateDefinition<Preferences>?
        get() = PreferencesGlanceStateDefinition

    override suspend fun provideGlance(context: Context, id: GlanceId) {
        val entryPoint = EntryPointAccessors.fromApplication(
            context,
            HabitWidetEntryPoint::class.java
        )
        val habitRepo = entryPoint.habitRepository()
        val habits = habitRepo.getHabitsForWorkManager()

        val completionMap = habits.associate {
            habit->
            val completions = habitRepo.fetchCompletionForWidget(
                habitId = habit.id,
                start = weekDays.first(),
                end = weekDays.last()
            ).map {
                it.date.toMidnight()
            }
            habit.id to completions
        }


        Log.d("WidgetUpdate", "Habits in DB: ${habits.map { it.title }}")

        provideContent {
            HabityList(
                modifier = GlanceModifier,
                habitList = habits,
                habitRepo = habitRepo,
                completionMap = completionMap
            )
        }
    }

    @Composable
    fun HabityList(
        modifier: GlanceModifier = GlanceModifier,
        habitList: List<Habit>,
        completionMap: Map<Long, List<Long>>,
        habitRepo: HabitRepo
    ) {
        val calendar = Calendar.getInstance()
        val todayWeekDay = calendar.get(Calendar.DAY_OF_WEEK)

        Box(
            modifier = GlanceModifier
                .fillMaxSize()
                .background(GlanceTheme.colors.widgetBackground)
                .cornerRadius(16.dp)
        ) {
            LazyColumn(
                modifier = GlanceModifier.padding(16.dp)
            ) {
                item {
                    Row(
                        modifier = GlanceModifier.fillMaxWidth()
                    ) {
                        Text(
                            text = "Habits",
                            style = TextStyle(
                                color = GlanceTheme.colors.onPrimaryContainer,
                                fontWeight = FontWeight.Bold,
                                fontSize = 14.sp
                            )
                        )
                        Spacer(modifier = GlanceModifier.defaultWeight())
                        Text(
                            text = "Completions(Week)",
                            style = TextStyle(
                                color = GlanceTheme.colors.onPrimaryContainer,
                                fontWeight = FontWeight.Bold,
                                fontSize = 14.sp
                            )
                        )
                    }
                }

                item {
                    Spacer(modifier = GlanceModifier.height(8.dp))
                }

                itemsIndexed(habitList) { index, habit ->

              val completions = completionMap[habit.id] ?:emptyList()
                    val dayBoxes = weekDays.mapIndexed { dayIndex, dayMillis ->
                        val isCompleted = completions.contains(dayMillis)
                        val isToday = todayWeekDay == (Calendar.SUNDAY + dayIndex)
                        Triple(isCompleted, isToday, dayMillis)
                    }

                    Row(modifier = GlanceModifier.fillMaxWidth()) {
                        Text(
                            text = habit.title,
                            style = TextStyle(color = GlanceTheme.colors.onPrimaryContainer)
                        )

                        Spacer(modifier = GlanceModifier.defaultWeight())

                        Row(verticalAlignment = Alignment.CenterVertically) {
                            for ((isCompleted, isToday, _) in dayBoxes) {
                                Box(
                                    modifier = GlanceModifier
                                        .padding(horizontal = 4.dp, vertical = 4.dp)
                                ) {
                                    Box(
                                        modifier = GlanceModifier
                                            .size(12.dp)
                                            .cornerRadius(4.dp)
                                            .background(
                                                if (isCompleted)
                                                    GlanceTheme.colors.primary
                                                else
                                                    GlanceTheme.colors.inversePrimary
                                            ),
                                        contentAlignment = Alignment.Center
                                    ) {
                                        if (isToday) {
                                            Box(
                                                modifier = GlanceModifier
                                                    .size(6.dp)
                                                    .cornerRadius(3.dp)
                                                    .background(GlanceTheme.colors.onPrimaryContainer)
                                            ){}
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
}
