package com.dev.habity.View.Screens

import android.content.Context
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
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
import androidx.compose.material.icons.filled.Analytics
import androidx.compose.material.icons.filled.Bedtime
import androidx.compose.material.icons.filled.Circle
import androidx.compose.material.icons.filled.ColorLens
import androidx.compose.material.icons.filled.DirectionsRun
import androidx.compose.material.icons.filled.EmojiEvents
import androidx.compose.material.icons.filled.Escalator
import androidx.compose.material.icons.filled.FitnessCenter
import androidx.compose.material.icons.filled.Flag
import androidx.compose.material.icons.filled.Height
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.MenuBook
import androidx.compose.material.icons.filled.MonitorWeight
import androidx.compose.material.icons.filled.SelfImprovement
import androidx.compose.material.icons.filled.SmokingRooms
import androidx.compose.material.icons.filled.Spa
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.filled.Straighten
import androidx.compose.material.icons.filled.Timeline
import androidx.compose.material.icons.filled.TrendingUp
import androidx.compose.material.icons.outlined.Analytics
import androidx.compose.material.icons.outlined.ColorLens
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Info
import androidx.compose.material.icons.rounded.Add
import androidx.compose.material.icons.rounded.Menu
import androidx.compose.material.icons.rounded.Search
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ContainedLoadingIndicator
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExperimentalMaterial3ExpressiveApi
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ListItem
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.ToggleButton
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.hapticfeedback.HapticFeedbackType
import androidx.compose.ui.platform.LocalHapticFeedback
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.dev.habity.Model.Database.Completion
import com.dev.habity.View.Navigation.Routes.Routes
import com.dev.habity.ViewModel.HabitDbViewmodel
import com.dev.habity.service.alarmmanger.HabityAlarmManager
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.time.LocalDate
import java.time.Year
import java.time.ZoneId
import java.util.Calendar

@OptIn(ExperimentalMaterial3Api::class, ExperimentalMaterial3ExpressiveApi::class)
@Composable
fun HomeScreen  (
    @ApplicationContext  context : Context,
    modifier: Modifier = Modifier,
    navController: NavController
) {
    val  scope = rememberCoroutineScope()

    val habitDbViewmodel: HabitDbViewmodel = hiltViewModel()

    //variable for haptics feedback
    val haptics = LocalHapticFeedback.current

    val habits by habitDbViewmodel.allHabit.observeAsState(emptyList())

    val date = Calendar.getInstance().get(Calendar.DAY_OF_YEAR)



    var selectedIndex by remember { mutableStateOf(0) }
    val year = LocalDate.of(LocalDate.now().year, 1, 1)

    val yearStartDay = LocalDate.of(LocalDate.now().year, 1, 1).dayOfWeek

    val totalItems = Year.now().length() + yearStartDay.value

      // scheduling alarm manager

//    LaunchedEffect(habits) {
//        habits.forEach {
//            habit->
//            HabityAlarmManager(
//                context = context
//            ).scheduleNotification(
//                week =  habit.notificationDays,
//                time = habit.notificationTime,
//                habitId = habit.id,
//                context = context
//            )
//
//        }
//    }

    fun Long.toDates(): Int {
        val calendar = Calendar.getInstance().apply {
            timeInMillis = this@toDates
            set(Calendar.HOUR_OF_DAY, 0)
            set(Calendar.MINUTE, 0)
            set(Calendar.SECOND, 0)
            set(Calendar.MILLISECOND, 0)

        }
        val year = calendar.get(Calendar.YEAR)
        val date = calendar.get(Calendar.DAY_OF_YEAR)
        return year * 1000 + date

    }

    fun Long.toDay(): Boolean {
        // setting the time to 0 to compare it to the next day M
        val todayStart = Calendar.getInstance()
            .apply {
                set(Calendar.HOUR_OF_DAY,0)
                set(Calendar.MINUTE,0)
                set(Calendar.SECOND,0)
                set(Calendar.MILLISECOND,0)
            }.timeInMillis
            // getting tomorrow
        val tomorrowStart = todayStart  + 24 * 60 * 60 * 1000L
            // returning if the given input falls between today and tomorrow Start
        return this in todayStart until tomorrowStart
    }
    fun LocalDate.toMillis(): Long {
        return this.atStartOfDay(ZoneId.systemDefault()).toInstant().toEpochMilli()
    }

    val navDrawerDest = listOf(
        DrawerItem(
            label = "Habity",
            icon = Icons.Outlined.Home,
            selectedIcon = Icons.Filled.Home,
            onClick = {}
            ),
        DrawerItem(
            label = "Analytics",
            icon = Icons.Outlined.Analytics,
            selectedIcon = Icons.Filled.Analytics,
            onClick = {
                navController.navigate(Routes.AnalyticsScreen.routes)
            }
        ),
        DrawerItem(
            label = "Theme",
            icon = Icons.Outlined.ColorLens,
            selectedIcon = Icons.Filled.ColorLens,
            onClick = {
                habitDbViewmodel.showNotification(
                    context = context
                )
            }
            ),
        DrawerItem(
            label = "About",
            icon = Icons.Outlined.Info,
            selectedIcon = Icons.Filled.Info,
            onClick = {}
            )
    )


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
   val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            ModalDrawerSheet(
                modifier = modifier.width(300.dp)
            ) {
              Column(
                  modifier = modifier.padding(horizontal = 16.dp, vertical = 8.dp)
              ) {
                 Spacer(
                     modifier = modifier.height(50.dp)
                 )
                  navDrawerDest.forEachIndexed {
                      index, item->
                      NavigationDrawerItem(
                          modifier = modifier.padding(vertical = 4.dp),
                          selected = selectedIndex== index,
                          onClick = {
                              item.onClick.invoke()
                              selectedIndex = index
                              scope.launch {
                                  drawerState.close()
                              }
                          },
                          icon = {
                              Icon(imageVector = if (selectedIndex== index) {
                                  item.selectedIcon!!
                              } else {
                                  item.icon!!
                              }, contentDescription = null)
                          },
                          label = {Text(
                              item.label.toString()
                          )}
                      )
                  }
              }
            }
        }
    ) {
        Scaffold(
            topBar = {
                CenterAlignedTopAppBar(
                    navigationIcon = {
                        IconButton(
                            onClick = {
                                habitDbViewmodel.showNotification(
                                    context = context
                                )
                                scope.launch {
                                    drawerState.open()
                                }
                            }
                        ) {
                            Icon(
                                imageVector = Icons.Rounded.Menu,
                                contentDescription = "Menu"
                            )
                        }
                    },
                    actions = {
                        IconButton(
                            onClick = {}
                        ) {
                            Icon(imageVector = Icons.Rounded.Search, contentDescription = null)
                        }
                    },

                    title = {
                        Text(text = "Habity")
                    }
                )
            },
            floatingActionButton = {
                ExtendedFloatingActionButton(onClick = {
                    navController.navigate(Routes.AddHabitScreen.routes)
                }) {
                    Icon(imageVector = Icons.Rounded.Add, contentDescription = null)
                    Spacer(modifier = modifier.width(4.dp))
                    Text(
                        text = "Add Habit"
                    )
                }
            }
        ) { innerPadding ->
            if (habits.isEmpty()) {
                Box(
                    modifier = modifier
                        .padding(innerPadding)
                        .fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
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
                itemsIndexed(habits) { index, habit ->
                    HabityAlarmManager(context).scheduleNotification(
                        habit.notificationDays,
                        time = habit.notificationTime,
                        habitId = habit.id,
                        context = context
                    )
                    val scrollState = rememberLazyGridState()
                    LaunchedEffect(
                        habit
                    ) {
                        scrollState.animateScrollToItem(
                            date
                        )
                    }
                    val completions by habitDbViewmodel.getCompletions(
                        habitId = habit.id
                    ).observeAsState(emptyList())
                    val icon = getIconByName(habit.icon ?: "Star")

                    ListItem(
                        shadowElevation = 20.dp,
                        modifier = modifier
                            .padding(
                                vertical = 4.dp
                            )
                            .clip(RoundedCornerShape(16.dp))
                            .clickable {  },
                        tonalElevation = 10.dp,
                        overlineContent = {
                            Text(
                                text = "Category - ${habit.category}  ${habit.id} ${habit.notificationTime}",
                            )
                        },
                        headlineContent = {
                            Row(
                                modifier = modifier.fillMaxWidth()
                            ) {
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
                                val todayCompletion = completions.filter {
                                    it.date.toDay()
                                }


                               val isChecked = todayCompletion.size >= habit.numberOfCompletion
                                ToggleButton(
                                    modifier = modifier.padding(
                                        bottom = 4.dp
                                    ),
                                    checked = isChecked,
                                    onCheckedChange = {
                                        val completion = Completion(
                                            habitId = habit.id,
                                            id = 0,
                                            date = System.currentTimeMillis(),
                                            completionTime = System.currentTimeMillis()
                                        )
                                        if (isChecked) {
                                            scope.launch(Dispatchers.IO) {
                                                val latestCompletions = habitDbViewmodel.getLatestCompletions(habit.id)
                                                habitDbViewmodel.deleteLatestCompletions(completion = latestCompletions)
                                            }

                                        } else {
                                            habitDbViewmodel.insertCompletion(
                                                completion = completion
                                            )
                                        }

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
                                            // subtracting the start of the year {int} to get actual day index
                                            val realDayIndex = it - yearStartDay.value
                                            // calculate date for the each box grid
                                            val boxDate = year.plusDays(
                                                realDayIndex.toLong()
                                            )
                                            val boxDayInt = boxDate.toMillis().toDates()
                                            // getting the actual today date for comparison
                                            val actualToday = LocalDate.now()
                                            val completedDays = completions.map {
                                                it.date.toDates()
                                            }
                                            val isComplete = completedDays.contains(boxDayInt)

                                            val isToday = actualToday == boxDate
                                            Box(
                                                modifier = Modifier
                                                    .padding(horizontal = 2.dp)
                                                    .size(12.dp)
                                                    .aspectRatio(1f)
                                                    .clip(RoundedCornerShape(3.dp))
                                                    .background(
                                                        when {
                                                            isComplete -> MaterialTheme.colorScheme.onPrimaryContainer   // completed other day

                                                            else -> MaterialTheme.colorScheme.inversePrimary   // not completed
                                                        }

                                                    )
                                            ) {
                                                if (isToday) {
                                                    Icon(
                                                        imageVector = Icons.Default.Circle,
                                                        contentDescription = null,
                                                        tint = MaterialTheme.colorScheme.onPrimary,
                                                        modifier = modifier
                                                            .size(8.dp)
                                                            .align(Alignment.Center)
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
}

data class DrawerItem(
    val icon : ImageVector ?= null,
    val selectedIcon : ImageVector ?= null,
    val onClick: () -> Unit,
    val label : String ? ="",
)

