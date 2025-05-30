package com.dev.habity.View.Screens

import android.content.Context
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.ScrollableDefaults
import androidx.compose.runtime.getValue
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.foundation.lazy.grid.rememberLazyGridState
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccessibilityNew
import androidx.compose.material.icons.filled.Bedtime
import androidx.compose.material.icons.filled.Circle
import androidx.compose.material.icons.filled.DirectionsRun
import androidx.compose.material.icons.filled.EmojiEvents
import androidx.compose.material.icons.filled.Escalator
import androidx.compose.material.icons.filled.FitnessCenter
import androidx.compose.material.icons.filled.Flag
import androidx.compose.material.icons.filled.Height
import androidx.compose.material.icons.filled.MenuBook
import androidx.compose.material.icons.filled.MonitorWeight
import androidx.compose.material.icons.filled.SelfImprovement
import androidx.compose.material.icons.filled.SmokingRooms
import androidx.compose.material.icons.filled.Spa
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.filled.Straighten
import androidx.compose.material.icons.filled.Timeline
import androidx.compose.material.icons.filled.TrendingUp
import androidx.compose.material.icons.rounded.Add
import androidx.compose.material.icons.rounded.Menu
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ContainedLoadingIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExperimentalMaterial3ExpressiveApi
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ListItem
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.ToggleButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.hapticfeedback.HapticFeedbackType
import androidx.compose.ui.platform.LocalHapticFeedback
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.dev.habity.Model.Database.Completion
import com.dev.habity.ViewModel.HabitDbViewmodel
import dagger.hilt.android.qualifiers.ApplicationContext
import java.time.LocalDate
import java.time.Year
import java.time.ZoneId
import java.util.Calendar
import javax.inject.Inject

@OptIn(ExperimentalMaterial3Api::class, ExperimentalMaterial3ExpressiveApi::class)
@Composable
fun HomeScreen  (
    @ApplicationContext  context : Context,
    modifier: Modifier = Modifier,
    onClick: () -> Unit
) {
    val   habitDbViewmodel : HabitDbViewmodel = hiltViewModel()

    //variable for haptics feedback
    val haptics = LocalHapticFeedback.current
    val habits by habitDbViewmodel.allHabit.observeAsState(emptyList())
    val date = Calendar.getInstance().get(Calendar.DAY_OF_YEAR)
    val  actualday: LocalDate = LocalDate.now()
    println("Actual Day: $actualday")
    //print(actualToday)

    val year = LocalDate.of(LocalDate.now().year ,1,1)
    println(year)
    val yearStartDay = LocalDate.of(LocalDate.now().year, 1,1).dayOfWeek
    val totalItems = Year.now().length() + yearStartDay.value
    fun Long.toDates() : Int {
        val calendar = Calendar.getInstance().apply {
          timeInMillis = this@toDates
          set(Calendar.HOUR_OF_DAY,0)
          set(Calendar.MINUTE, 0)
          set(Calendar.SECOND,0)
          set(Calendar.MILLISECOND,0)

        }
        val year = calendar.get(Calendar.YEAR)
        val date = calendar.get(Calendar.DAY_OF_YEAR)
        return year * 1000 + date

    }
    fun LocalDate.toMillis(): Long {
        return this.atStartOfDay(ZoneId.systemDefault()).toInstant().toEpochMilli()
    }


    //val habits = habitValues.value

    fun getIconByName(name: String): ImageVector {
        val habitIconMap = mapOf(
            "FitnessCenter" to Icons.Default.FitnessCenter,
            "MenuBook" to Icons.Default.MenuBook,
            "SelfImprovement" to Icons.Default.SelfImprovement,
            "DirectionsRun" to Icons.Default.DirectionsRun,
            "Bedtime" to Icons.Default.Bedtime,
            "Spa" to Icons.Default.Spa,
            "SmokingRooms" to Icons.Default.SmokingRooms,
            "EmojiEvents" to Icons.Default.EmojiEvents,
            "AccessibilityNew" to Icons.Default.AccessibilityNew,
            "Height" to Icons.Default.Height,
            "Escalator" to Icons.Default.Escalator,
            "TrendingUp" to Icons.Default.TrendingUp,
            "Timeline" to Icons.Default.Timeline,
            "MonitorWeight" to Icons.Default.MonitorWeight,
            "Straighten" to Icons.Default.Straighten,
            "Flag" to Icons.Default.Flag,
        )

        return habitIconMap[name] ?: Icons.Default.Star // fallback icon
    }

    Scaffold (
        topBar = {
            CenterAlignedTopAppBar(
                navigationIcon = {
                    IconButton(
                        onClick = {

                        }
                    ) {
                        Icon(
                            imageVector = Icons.Rounded.Menu,
                            contentDescription = "Menu"
                        )
                     }
                },

                title = {
                    Text(text = "Habity")
                }
            )
        },
        floatingActionButton = {
            ExtendedFloatingActionButton (onClick = {
                onClick.invoke()
            }) {
                Icon(imageVector = Icons.Rounded.Add, contentDescription = null)
                Spacer(modifier = modifier.width(4.dp))
                Text(
                    text = "Add Habit"
                )
            }
        }
    ) { innerPadding ->
        if (habits.isEmpty()){
            Box (
                modifier = modifier
                    .padding(innerPadding)
                    .fillMaxSize(),
                contentAlignment = Alignment.Center
            ){
                Column(
                    modifier = modifier.fillMaxSize(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    ContainedLoadingIndicator(
                        modifier = modifier.size(150.dp)
                        )

                    Text(
                        modifier = modifier.padding(
                            top = 32.dp
                        ),
                        text = "Add a habit to get started!",
                    )
                }
            }
        }
        LazyColumn(
            modifier = modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(horizontal = 16.dp)
        ) {
            itemsIndexed (habits) { index, habit ->
                val scrollState = rememberLazyGridState()
                LaunchedEffect(
                    habit
                ) {
                    scrollState.animateScrollToItem(
                        date
                    )
                }
                val completion by habitDbViewmodel.getCompletions(
                    habitId = habit.id
                ).observeAsState(emptyList())
                val millisPerDay = 24 * 60 * 60 * 1000L
                val icon = getIconByName(habit.icon ?: "Star") // Default to "Star" if icon is null
                ListItem(
                    shadowElevation = 20.dp,
                    modifier = modifier
                        .padding(
                            vertical = 4.dp
                        )
                        .clip(RoundedCornerShape(16.dp)),
                    tonalElevation = 100.dp,
                    overlineContent = {
                        Text(
                            text = "Category - ${habit.category }  ${habit.id}",
                        )
                    },
                    headlineContent = {
                       Row (
                           modifier = modifier.fillMaxWidth()
                       ){
                          Column {
                              Text(
                                  text = habit.title,
                                  fontWeight = FontWeight.SemiBold
                              )
                              Text(
                                  text = habit.description,
                                  style = MaterialTheme.typography.bodyMedium
                              )
                          }
                           Spacer(modifier = modifier.weight(1f))
                          ToggleButton(
                              modifier = modifier.padding(
                                  bottom = 4.dp
                              ),
                              checked = habit.numberOfCompletion == completion.size,
                              onCheckedChange = {
                                  val completion = Completion(
                                      habitId = habit.id,
                                      id = 0,
                                      date = System.currentTimeMillis(),
                                  )
                                  habitDbViewmodel.insertCompletion(
                                      completion = completion
                                  )
                                  haptics.performHapticFeedback(
                                      hapticFeedbackType = HapticFeedbackType.ContextClick
                                  )
                              }
                          ) {
                              Icon(
                                  imageVector = icon,
                                  contentDescription = null
                              )
                          }
                       }
                    },
                    supportingContent = {
                        Column(
                            modifier = modifier.fillMaxWidth()
                        ) {
                            LazyHorizontalGrid(
                                state = scrollState,
                                modifier = modifier.height(
                                    120.dp
                                ),
                                userScrollEnabled = true,
                                rows = GridCells.Fixed(7),
                                flingBehavior = ScrollableDefaults.flingBehavior()

                            ) {
                                items(totalItems) {
                                    if (it < yearStartDay.value) {
                                        // Placeholder for days before the start of the year
                                        Box(
                                            modifier = Modifier
                                                .padding(horizontal = 2.dp)
                                                .size(12.dp)
                                                .aspectRatio(1f)
                                                .clip(RoundedCornerShape(3.dp))
                                                .background(MaterialTheme.colorScheme.onSurface)
                                        )

                                    } else {
                                        // subracting thr start of the year {int} to get actual day index
                                        val realDayIndex = it - yearStartDay.value
                                        // calculate date for the each box grid
                                        val boxDate = year.plusDays(
                                            realDayIndex.toLong()
                                        )
                                        val boxDayInt = boxDate.toMillis().toDates()
                                        // getting the actual today date for comparison
                                        val actualToday = LocalDate.now()
                                        val completedDays = completion.map {
                                            it.date.toDates()
                                        }
                                        val isComplete =  completedDays.contains(boxDayInt)

                                        val isToday = actualToday == boxDate
                                        Box(
                                            modifier = Modifier
                                                .padding(horizontal = 2.dp)
                                                .size(12.dp)
                                                .aspectRatio(1f)
                                                .clip(RoundedCornerShape(3.dp))
                                                .background(
                                                    when {
                                                        isComplete -> MaterialTheme.colorScheme.primary   // completed other day

                                                        else -> MaterialTheme.colorScheme.surfaceContainerLowest    // not completed
                                                    }

                                                )
                                        ){
                                            if (isToday){
                                                Icon(
                                                    imageVector = Icons.Default.Circle,
                                                    contentDescription = null,
                                                    tint = MaterialTheme.colorScheme.onPrimary,
                                                    modifier = modifier.size(8.dp).align(Alignment.Center)
                                                )
                                            }
                                        }

                                    }

                                }
                            }

                        }
                    }
                )
            }
        }
    }
}



