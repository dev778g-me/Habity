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
import androidx.compose.material.icons.rounded.CalendarViewWeek
import androidx.compose.material.icons.rounded.Category
import androidx.compose.material.icons.rounded.CheckCircle
import androidx.compose.material.icons.rounded.Circle
import androidx.compose.material.icons.rounded.CircleNotifications
import androidx.compose.material.icons.rounded.Done
import androidx.compose.material.icons.rounded.DownloadDone
import androidx.compose.material.icons.rounded.PlusOne
import androidx.compose.material.icons.rounded.Today
import androidx.compose.material3.AssistChip
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ButtonGroup
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
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.dev.habity.Model.Database.Completion

import com.dev.habity.Model.Database.Habit
import com.dev.habity.Model.Database.HabitDatabase
import com.dev.habity.ViewModel.HabitDbViewmodel
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
    val context = LocalContext.current
    val hazeState = rememberHazeState()


    val options = listOf("Daily", "Weekly", "Monthly")
    val remainderDays = listOf("All" ,"Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat")
    val colorOptions = listOf(
        Color(0xFFFFDBD1), // Soft Peach
        Color(0xFFcdeda3), // Light Green
        Color(0xFFbcece7), // Soft Cyan
        Color(0xFFeee2bc), // Warm Beige
        Color(0xFFffd6fe), // Pink Lavender
        Color(0xFFa2eeff), // Baby Blue
        Color(0xFFe0e0ff), // Lavender Gray
        Color(0xFF74649f), // Dusty Purple
        Color(0xFFFFC1CC), // Pastel Pink
        Color(0xFFA0E7E5), // Aquamarine
        Color(0xFFFFF6C3), // Light Yellow
        Color(0xFFB5EAD7), // Mint Green
        Color(0xFFC7CEEA)  // Periwinkle
    )
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
    val newCategory = mapOf(
        "Health" to Icons.Default.Favorite,
        "Study" to Icons.Default.School,
        "Personal" to Icons.Default.Person,
        "Hobby" to Icons.Default.EmojiEmotions,
        "Music" to Icons.Default.LibraryMusic,
        "Coding" to Icons.Default.Code,
        "Reading" to Icons.Default.MenuBook,
        "Diet" to Icons.Default.EmojiFoodBeverage,
        "Other" to Icons.Default.MoreHoriz,

        )


    var title by remember { mutableStateOf("") }
    var description by remember { mutableStateOf("") }
    var bottomSheetVisible by remember { mutableStateOf(false) }

    val selectedChips = remember { mutableStateOf(newCategory.keys.first()) }
    val selectedDays = remember { mutableStateMapOf<String, Boolean>() }
    val selectedColor = remember { mutableStateOf(colorOptions[0]) }
    val selectedIcon = remember { mutableStateOf(habitIconMap.keys.first()) }
    var numberOfCompletion by remember { mutableIntStateOf(1) }
    val isEmpty by remember(title,description) { mutableStateOf(title.isNotEmpty() && description.isNotEmpty()) }

    val coroutineScope = rememberCoroutineScope()



    remainderDays.forEach {
        if (selectedDays[it] == null) {
            selectedDays[it] = false
        }
    }

    var selectedOption by remember { mutableStateOf(0) }



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
                        value = title,
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
                        onValueChange = { title = it },
                        shape = RoundedCornerShape(8.dp)
                    )
                }

                item {
                    OutlinedTextField(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 5.dp),
                        maxLines = 1,
                        value = description,
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
                        onValueChange = { description = it },
                        shape = RoundedCornerShape(8.dp)
                    )
                }

                item {
                    Text(
                        modifier = Modifier
                            // .align(Alignment.Start)
                            .padding(vertical = 5.dp),
                        text = "Streak Goal",
                        style = MaterialTheme.typography.labelLarge
                    )
                }

                item {
                    SingleChoiceSegmentedButtonRow(
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        options.forEachIndexed { index, option ->
                            SegmentedButton(
                                shape = SegmentedButtonDefaults.itemShape(index = index, count = options.size),
                                selected = selectedOption == index,
                                onClick = { selectedOption = index },
                                label = { Text(text = option) }
                            )
                        }
                    }
                }
                item {
                    Text(
                        modifier = Modifier
                            // .align(Alignment.Start)
                            .padding(vertical = 5.dp),
                        text = "Completion Per Day",
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
                                text = "$numberOfCompletion/day"
                            )

                        }
                        FilledTonalIconButton(
                            enabled = numberOfCompletion != 1,

                            onClick = {
                            if (numberOfCompletion>1){
                                numberOfCompletion --
                            }
                        }) {
                            Icon(imageVector = Icons.Default.Remove, contentDescription = null)
                        }
                        FilledTonalIconButton(onClick = {
                            numberOfCompletion ++
                        }) {
                            Icon(imageVector = Icons.Default.Add, contentDescription = null)
                        }
                    }
                }

                item {
                    Text(
                        modifier = Modifier
                            //.align(Alignment.Start)
                            .padding(vertical = 5.dp),
                        text = "Reminder",
                        style = MaterialTheme.typography.labelLarge
                    )
                }

                item {
                    FlowRow(
                        modifier = Modifier
                            .fillMaxWidth()
                        //.align(Alignment.CenterHorizontally)
                    ) {
                        remainderDays.forEachIndexed { index, days ->
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
                                label = { Text(text = days) },
                                onClick = {
                                    if (days == "All") {
                                        val newState = selectedDays["All"] != true
                                        remainderDays.forEach {
                                            selectedDays[it] = newState
                                        }
                                    } else {
                                        selectedDays[days] = !(selectedDays[days] ?: false)
                                        val allSelected = remainderDays.drop(1).all { selectedDays[it] == true }
                                        selectedDays["All"] = allSelected
                                    }
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
                            //.align(Alignment.Start)
                            .padding(vertical = 5.dp),
                        text = "Select Color",
                        style = MaterialTheme.typography.labelLarge
                    )
                }

                item {
                    Box(
                        modifier = modifier.height(150.dp)

                    ) { LazyVerticalGrid(
                        columns = GridCells.Fixed(5),
                        modifier = Modifier
                            .fillMaxWidth(),
                         //   .height(120.dp),
                        userScrollEnabled = true
                    ) {
                        items(colorOptions) { color ->
                            FilledTonalIconButton(
                                modifier = modifier.padding(horizontal = 4.dp),
                                onClick = { selectedColor.value = color },
                                colors = IconButtonDefaults.iconButtonColors(
                                    containerColor = color,
                                    contentColor = color
                                )
                            ) {
                                AnimatedContent(targetState = selectedColor.value == color) {
                                    if (it) {
                                        Icon(
                                            imageVector = Icons.Rounded.CheckCircle,
                                            contentDescription = null,
                                            tint = Color.Black
                                        )
                                    }
                                }
                            }
                        }
                    }
                    }
                }

                item {
                    Text(
                        modifier = Modifier
                            //.align(Alignment.Start)
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
                        items(habitIconMap.entries.toList()) { entry ->
                            val icon = entry.value
                            FilledIconToggleButton(
                                modifier = modifier.padding(horizontal = 4.dp),
                                checked = selectedIcon.value == entry.key,
                                onCheckedChange = { selectedIcon.value = entry.key }
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
                val colorCode = selectedColor.value.toArgb()

               Button(
                   enabled = isEmpty,
                   modifier = modifier
                       .fillMaxWidth()
                       .padding(horizontal = 16.dp),
                   onClick = {
                       val iconName = selectedIcon.value
                       val colorCode = selectedColor.value.toArgb()
                       val  categoryName = selectedChips.value

                       val newHabit = Habit(
                           title = title,
                           description = description,
                           id = 0,
                           category = categoryName,
                           color = colorCode.toString(),
                           icon = selectedIcon.value,
                           numberOfCompletion = numberOfCompletion,
                           createdAt = System.currentTimeMillis(),
                       )

                       viewmodel.insertHabit(
                           habit = newHabit
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
                            items(newCategory.entries.toList()) {
                                    chip ->
                                val name = chip.key
                                val chipname =


                                InputChip(
                                    modifier = Modifier.padding(horizontal = 3.dp),
                                    selected = selectedChips.value == chip.key,
                                    onClick = {
                                       selectedChips.value = chip.key
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