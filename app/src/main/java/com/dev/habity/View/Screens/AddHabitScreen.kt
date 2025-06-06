package com.dev.habity.View.Screens

import android.widget.Toast
import androidx.compose.animation.AnimatedContent
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.DirectionsRun
import androidx.compose.material.icons.automirrored.filled.MenuBook
import androidx.compose.material.icons.automirrored.filled.TrendingUp
import androidx.compose.material.icons.filled.AccessibilityNew
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Bedtime
import androidx.compose.material.icons.filled.CalendarViewWeek
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Code
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Description
import androidx.compose.material.icons.filled.DirectionsRun
import androidx.compose.material.icons.filled.DriveFileRenameOutline
import androidx.compose.material.icons.filled.EmojiEmotions
import androidx.compose.material.icons.filled.EmojiEvents
import androidx.compose.material.icons.filled.EmojiFoodBeverage
import androidx.compose.material.icons.filled.Escalator
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FitnessCenter
import androidx.compose.material.icons.filled.Flag
import androidx.compose.material.icons.filled.Height
import androidx.compose.material.icons.filled.Hub
import androidx.compose.material.icons.filled.LibraryMusic
import androidx.compose.material.icons.filled.MenuBook
import androidx.compose.material.icons.filled.MonitorWeight
import androidx.compose.material.icons.filled.MoreHoriz
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Remove
import androidx.compose.material.icons.filled.School
import androidx.compose.material.icons.filled.SelfImprovement
import androidx.compose.material.icons.filled.SmokingRooms
import androidx.compose.material.icons.filled.Spa
import androidx.compose.material.icons.filled.Straighten
import androidx.compose.material.icons.filled.Timeline
import androidx.compose.material.icons.filled.TipsAndUpdates
import androidx.compose.material.icons.filled.TrendingUp
import androidx.compose.material.icons.rounded.AccessTimeFilled
import androidx.compose.material.icons.rounded.Bedtime
import androidx.compose.material.icons.rounded.CalendarViewWeek
import androidx.compose.material.icons.rounded.Category
import androidx.compose.material.icons.rounded.CheckCircle
import androidx.compose.material.icons.rounded.Circle
import androidx.compose.material.icons.rounded.CircleNotifications
import androidx.compose.material.icons.rounded.Done
import androidx.compose.material.icons.rounded.DownloadDone
import androidx.compose.material.icons.rounded.Event
import androidx.compose.material.icons.rounded.LightMode
import androidx.compose.material.icons.rounded.MoreVert
import androidx.compose.material.icons.rounded.Nightlight
import androidx.compose.material.icons.rounded.PlusOne
import androidx.compose.material.icons.rounded.PowerSettingsNew
import androidx.compose.material.icons.rounded.Schedule
import androidx.compose.material.icons.rounded.Today
import androidx.compose.material.icons.rounded.Tsunami
import androidx.compose.material.icons.rounded.WbSunny
import androidx.compose.material.icons.rounded.WbTwilight
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.AssistChip
import androidx.compose.material3.BasicAlertDialog
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ButtonGroup
import androidx.compose.material3.ButtonGroupScope
import androidx.compose.material3.Card
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExperimentalMaterial3ExpressiveApi
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.FilledIconToggleButton
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.FilledTonalIconButton
import androidx.compose.material3.FilterChip
import androidx.compose.material3.FilterChipDefaults
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.InputChip
import androidx.compose.material3.InputChipDefaults
import androidx.compose.material3.ListItem
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.MultiChoiceSegmentedButtonRow
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SegmentedButton
import androidx.compose.material3.SegmentedButtonColors
import androidx.compose.material3.SegmentedButtonDefaults
import androidx.compose.material3.SingleChoiceSegmentedButtonRow
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TimePicker
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.rememberTimePickerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateMapOf

import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.hapticfeedback.HapticFeedbackType
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalHapticFeedback
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import androidx.hilt.navigation.compose.hiltViewModel
import com.dev.habity.Model.Database.Completion

import com.dev.habity.Model.Database.Habit
import com.dev.habity.Model.Database.HabitDatabase
import com.dev.habity.ViewModel.HabitDbViewmodel
import com.dev.habity.ViewModel.HabityStateViewModel
import dev.chrisbanes.haze.HazeStyle
import dev.chrisbanes.haze.HazeTint
import dev.chrisbanes.haze.hazeChild
import dev.chrisbanes.haze.hazeEffect
import dev.chrisbanes.haze.hazeSource
import dev.chrisbanes.haze.materials.ExperimentalHazeMaterialsApi
import dev.chrisbanes.haze.materials.HazeMaterials
import dev.chrisbanes.haze.rememberHazeState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.time.LocalTime
import java.util.Calendar


@OptIn(ExperimentalMaterial3Api::class, ExperimentalLayoutApi::class,
    ExperimentalHazeMaterialsApi::class, ExperimentalMaterial3ExpressiveApi::class
)
@Composable
fun AddHabitScreen(
    modifier: Modifier = Modifier,
    onNavigation: () -> Unit
) {

    // variable for thr haptics
    val haptics = LocalHapticFeedback.current

    val viewmodel : HabitDbViewmodel = hiltViewModel()
    val habityStateViewModel : HabityStateViewModel = hiltViewModel()
    val context = LocalContext.current
    val hazeState = rememberHazeState()


    // State management for the UI
    // variable to manage the habit name state
    val habitName by habityStateViewModel.habitName.collectAsState()
    // variable to manage the habit description state
    val habitDescription by habityStateViewModel.habitDescription.collectAsState()
    // variable to check is the habit name ans description are empty or not
    val canAddHabit by habityStateViewModel.canAddHabit.collectAsState()
    // variable to manage state of the number of completions
    val numberOfCompletions by habityStateViewModel.numberOFCompletion.collectAsState()
    // variable to manage state of the category
    val categoryIconMap = habityStateViewModel.categoryIconMap
     // variable to manage the selected category
    val selectedCategory by habityStateViewModel.habitCategory.collectAsState()

    // variable to mange the icon for tha habit
    val habitIcon = habityStateViewModel.habitIconMap
    val selectedIcon by habityStateViewModel.habitIcon.collectAsState()

    // variable to manage the streak goal
    val streakGoalList = habityStateViewModel.streakOptions
    val selectedStreakGoal by habityStateViewModel.streakGoal.collectAsState()

    // variable for managing the time
    val time = habityStateViewModel.timeOptionsMap
    val timeOptions by habityStateViewModel.timeOptions.collectAsState()

    val remainderDays = listOf("All" ,"Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat")
    val daysIndex = (0..7).toList()
    var bottomSheetVisible by remember { mutableStateOf(false) }
    val selectedDays = remember { mutableStateMapOf<Int, Boolean>() }

    // calender
    val calendar = Calendar.getInstance()

    var showDialog by remember { mutableStateOf(false) }

    var timePickerState = rememberTimePickerState(
        initialMinute = calendar.get(Calendar.MINUTE),
        initialHour = calendar.get(Calendar.HOUR_OF_DAY),
        is24Hour = false
    )
  LaunchedEffect(Unit) {
     daysIndex.forEach{
         selectedDays[it] = false
     }
  }



    Scaffold(
        containerColor = MaterialTheme.colorScheme.surface,
        topBar = {
            TopAppBar(
                navigationIcon = {
                    IconButton(
                        onClick = {
                        onNavigation.invoke()
                    }
                    ) {
                        Icon(imageVector = Icons.Default.Close, contentDescription = "close")
                    }

                },
                title = {
                    Text(text = "New Habity")
                }
            )
        },
        contentWindowInsets = WindowInsets(0.dp)

    ) {

        innerPadding ->
        val selectedhour = timePickerState.hour
        val selectedMin = timePickerState.minute
        println(selectedhour)
        println("min ${selectedMin}")
        if (showDialog){
            AlertDialog(
                title = {
                    Text(
                        text = "Select Time"
                    )
                },
                onDismissRequest = {
                    showDialog = !showDialog
                },
                confirmButton = {
                   Button(
                       onClick = {
                           showDialog = !showDialog
                       }
                   ) {
                       Text(
                           text = "Confirm"
                       )
                   }
                },
                dismissButton = {
                    OutlinedButton(
                        onClick = {
                            showDialog = !showDialog
                        }
                    ) {
                        Text(
                            text = "Cancel"
                        )
                    }
                },
                text = {
                    TimePicker(

                        state = timePickerState
                    )
                }
            )


        }
        Box(
            modifier = modifier
                .fillMaxSize()
                .padding(innerPadding)

        ) {
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .hazeSource(state = hazeState)
                    .padding(horizontal = 20.dp),
                horizontalAlignment = Alignment.Start
            ) {
                item {
                    OutlinedTextField(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 5.dp),
                        maxLines = 1,
                        value = habitName,
                        leadingIcon = {
                            Icon(
                                imageVector = Icons.Default.DriveFileRenameOutline,
                                contentDescription = null
                            )
                        },
                        placeholder = {
                            Text(text = "Enter Habit")
                        },
                        label = {
                            Text(text = "Habit Name")
                        },
                        onValueChange = {
                            habityStateViewModel.onHabitNameChanged(it)
                        },
                        shape = RoundedCornerShape(8.dp),
                        keyboardOptions = KeyboardOptions(
                            imeAction = ImeAction.Next,

                        )
                    )
                }

                item {
                    OutlinedTextField(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 5.dp),
                        maxLines = 1,
                        value = habitDescription,
                        leadingIcon = {
                            Icon(
                                imageVector = Icons.Default.Description,
                                contentDescription = null
                            )
                        },
                        placeholder = {
                            Text(text = "Enter Description")
                        },
                        label = {
                            Text(text = "Description")
                        },
                        onValueChange = {
                            habityStateViewModel.onHabitDescriptionChanged(it)
                        },
                        shape = RoundedCornerShape(8.dp),

                        keyboardOptions = KeyboardOptions(
                            imeAction = ImeAction.Done,

                            )
                    )
                }

                item {
                    Text(
                        modifier = Modifier
                            .padding(vertical = 5.dp),
                        text = "Streak Goal",
                        style = MaterialTheme.typography.labelLarge
                    )
                }

                item {
                    SingleChoiceSegmentedButtonRow(
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        streakGoalList.forEachIndexed { index, option ->
                            SegmentedButton(
                                shape = SegmentedButtonDefaults.itemShape(index = index, count = streakGoalList.size),
                                selected = selectedStreakGoal == option,
                                onClick = {
                                    haptics.performHapticFeedback(
                                        hapticFeedbackType = HapticFeedbackType.Confirm
                                    )
                                    habityStateViewModel.setStreakGoal(
                                        option
                                    )
                                },
                                label = { Text(text = option) }
                            )
                        }
                    }
                }
                item {
                    Text(
                        modifier = Modifier
                            .padding(vertical = 5.dp),
                        text = "Completion Per $selectedStreakGoal",
                        style = MaterialTheme.typography.labelLarge
                    )
                }
                item {
                    Row (
                        modifier = modifier
                            .fillMaxWidth()
                            .padding(vertical = 4.dp)
                    ){
                        Card (
                            modifier = modifier.weight(1f)

                        ){
                            Text(
                                modifier = modifier
                                    .padding(
                                    vertical = 16.dp,
                                    horizontal = 20.dp
                                ),
                                style = MaterialTheme.typography.labelLarge,
                                text = "$numberOfCompletions / $selectedStreakGoal"
                            )

                        }
                        FilledTonalIconButton(
                            enabled = numberOfCompletions != 1,
                            onClick = {
                                haptics.performHapticFeedback(
                                    hapticFeedbackType = HapticFeedbackType.TextHandleMove
                                )
                            if (numberOfCompletions>1){
                                habityStateViewModel.decrementNumberOfCompletion()
                            }
                        }) {
                            Icon(imageVector = Icons.Default.Remove, contentDescription = null)
                        }
                        FilledTonalIconButton(onClick = {
                            haptics.performHapticFeedback(
                                hapticFeedbackType = HapticFeedbackType.TextHandleMove
                            )
                           habityStateViewModel.incrementNumberOfCompletion()
                        }) {
                            Icon(imageVector = Icons.Default.Add, contentDescription = null)
                        }
                    }
                }

                item {
                    Text(
                        modifier = Modifier

                            .padding(vertical = 5.dp),
                        text = "Reminder",
                        style = MaterialTheme.typography.labelLarge
                    )
                }

                item {
                    FlowRow(
                        modifier = Modifier
                            .fillMaxWidth()
                    ) {
                        daysIndex.forEachIndexed { index, days ->
                            val isSelected = selectedDays[days] == true
                            FilterChip(
                                leadingIcon = {
                                    AnimatedContent(targetState = isSelected) {
                                        if (it) {
                                            Icon(
                                                imageVector = Icons.Rounded.Done,
                                                contentDescription = null,
                                                modifier = Modifier.size(FilterChipDefaults.IconSize)
                                            )
                                        } else {
                                            Icon(
                                                imageVector = Icons.Rounded.Today,
                                                contentDescription = null,
                                                modifier = Modifier.size(FilterChipDefaults.IconSize)
                                            )
                                        }
                                    }
                                },
                                modifier = modifier.padding(horizontal = 4.dp),
                                selected = isSelected,
                                label = { Text(text = remainderDays[index]) },
                                onClick = {
                                    if (days == 0) {
                                        val newState = selectedDays[0] != true
                                        for (i in daysIndex) {
                                            selectedDays[i] = newState
                                        }
                                    } else {
                                        selectedDays[days] = !(selectedDays[days] ?: false)
                                        val allSelected = daysIndex.drop(1).all { selectedDays[it] == true }
                                        selectedDays[0] = allSelected
                                    }

                                    haptics.performHapticFeedback(
                                        hapticFeedbackType = HapticFeedbackType.Confirm
                                    )

                                    // Show selected days in Toast (excluding "All")
                                    val selected = selectedDays
                                        .filter { it.key != 0 && it.value }
                                        .keys
                                        .sorted()
                                        .joinToString(", ") { remainderDays[it] }


                                }

                            )
                        }
                    }
                }

                item {
                    Text(
                        modifier = Modifier
                            .padding(vertical = 5.dp),
                        text = "Select Time For Reminder",
                        style = MaterialTheme.typography.labelLarge
                    )
                }
                item {
                    FlowRow(
                        modifier = modifier.fillMaxWidth()
                    ) {
                        time.forEach{
                            FilterChip(

                                leadingIcon = {
                                    Icon(
                                        imageVector = when (it.key) {
                                            "Morning" -> Icons.Rounded.WbTwilight
                                            "Afternoon" -> Icons.Rounded.LightMode
                                            "Evening" -> Icons.Rounded.Nightlight
                                            "Night" -> Icons.Rounded.Bedtime
                                            "Before Bed" -> Icons.Rounded.PowerSettingsNew
                                            else -> Icons.Rounded.Schedule
                                        },
                                        modifier = modifier.size(FilterChipDefaults.IconSize),
                                        contentDescription = null
                                    )

                                },
                                modifier = modifier.padding(
                                    horizontal = 4.dp
                                ),
                                selected = timeOptions == it.key,
                                label = {
                                    Text(
                                        text = it.key,

                                    )
                                },
                                onClick = {
                                    if (it.key == "Custom"){
                                         showDialog = true
                                        habityStateViewModel.changeTime(time = it.key)
                                    }else {
                                    habityStateViewModel.changeTime(
                                        time = it.key
                                    )
                                    haptics.performHapticFeedback(
                                        hapticFeedbackType = HapticFeedbackType.Confirm
                                    )}
                                }
                            )
                        }
                    }

                }
                item {
                    FilledTonalButton(
                        modifier = modifier.fillMaxWidth(),
                        onClick = { bottomSheetVisible = !bottomSheetVisible }
                    ) {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.Center
                        ) {
                            Icon(
                                imageVector = Icons.Rounded.Category,
                                contentDescription = null,
                                modifier = Modifier.size(ButtonDefaults.IconSize)
                            )
                            Spacer(modifier = Modifier.width(5.dp))
                            Text("Add Category")
                        }
                    }
                }


                item {
                    Text(
                        modifier = Modifier
                            .padding(vertical = 5.dp),
                        text = "Select Icon",
                        style = MaterialTheme.typography.labelLarge
                    )
                }

                item {
                    LazyVerticalGrid(
                        columns = GridCells.Fixed(5),
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(200.dp),
                        userScrollEnabled = false,
                        contentPadding = PaddingValues(
                           // bottom = 200.dp
                        )
                    ) {
                        items(habitIcon.entries.toList()) { entry ->
                            val icon = entry.value
                            FilledIconToggleButton(
                                modifier = modifier.padding(horizontal = 4.dp),
                                checked = selectedIcon == entry.key,
                                onCheckedChange = {
                                    haptics.performHapticFeedback(
                                        hapticFeedbackType = HapticFeedbackType.Confirm
                                    )
                                    habityStateViewModel.setHabitIcon(entry.key) }
                            ) {
                                Icon(imageVector = icon, contentDescription = icon.name)
                            }
                        }
                    }
                }
                item {
                    Spacer(
                        modifier = modifier
                            .height(150.dp,)
                            .fillMaxWidth()
                            .background(Color.Transparent)
                    )
                }

            }

            BottomAppBar(
               tonalElevation = 10.dp,
                containerColor = Color.Transparent,
                modifier = modifier
                    .hazeEffect(
                        state = hazeState,
                        style = HazeMaterials.ultraThin()
                    )
                    .fillMaxWidth()
                    .align(Alignment.BottomCenter)
            ) {

               Button(
                   enabled = canAddHabit,
                   modifier = modifier
                       .fillMaxWidth()
                       .padding(horizontal = 16.dp),
                   onClick = {
                       val  categoryName = selectedCategory
                       val selectedNotificationDays = selectedDays.filter {
                           it.key != 0 && it.value
                       }.map {
                           it.key
                       }
                       val newHabit = Habit(
                           title = habitName,
                           description = habitDescription,
                           id = 0,
                           category = categoryName.toString(),
                           icon = selectedIcon,
                           numberOfCompletion = numberOfCompletions,
                           streakType = selectedStreakGoal,
                           notificationDays = selectedNotificationDays,
                           notificationTime = if (timeOptions =="Custom"){
                               LocalTime.of(selectedhour,selectedMin)
                           }else {
                               time[timeOptions]!!
                           },
                           createdAt = System.currentTimeMillis(),
                       )

                       viewmodel.insertHabitAndUpdateWidget(
                           habit = newHabit,
                           context = context
                       )

                       print("the habit id ${newHabit.id}")
                       Toast.makeText(
                           context, "Habit added successfully", Toast.LENGTH_SHORT
                       ).show()
                          haptics.performHapticFeedback(
                              hapticFeedbackType = HapticFeedbackType.Confirm
                          )
                       onNavigation.invoke()


                   }
               ) {
                   Text(text = "Add Habit")
               }
            }
        }



        if (bottomSheetVisible){
            ModalBottomSheet(
                onDismissRequest = { bottomSheetVisible = false },
            ) {
                Box(
                    modifier = Modifier.fillMaxHeight(0.5f)
                ) {
                    Column (
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(horizontal = 20.dp, vertical = 10.dp),
                    ){
                        Text(text = "Select Category", style = MaterialTheme.typography.titleLarge, modifier = Modifier.padding(vertical = 5.dp))

                        Text(text = "Pick one or more categories that best describe your habit", style = MaterialTheme.typography.bodySmall )

                        LazyVerticalGrid(
                            modifier = Modifier.padding(vertical = 10.dp),
                            columns = GridCells.Adaptive(minSize = 100.dp),

                            ) {
                            items(categoryIconMap.entries.toList()) {
                                    chip ->
                                val name = chip.key
                                InputChip(
                                    modifier = Modifier.padding(horizontal = 3.dp),
                                    selected = selectedCategory == name,
                                    onClick = {
                                      habityStateViewModel.setHabitCategory(name)
                                    },
                                    label = {
                                        Text(text = name)
                                    },
                                    leadingIcon = {
                                        Icon(imageVector = chip.value, contentDescription = null,
                                            Modifier.size(InputChipDefaults.IconSize))
                                    }
                                )
                            }

                        }

                        Spacer(modifier = Modifier.weight(1f))

                        Button(onClick = {
                              bottomSheetVisible = false
                        }, modifier = Modifier
                            .fillMaxWidth()
                            .padding(bottom = 30.dp))
                        {
                            Text(text = "Save Category")
                        }


                    }
                }
            }
        }
    }
}