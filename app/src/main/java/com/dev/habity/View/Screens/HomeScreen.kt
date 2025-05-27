package com.dev.habity.View.Screens

import androidx.compose.foundation.background
import androidx.compose.runtime.getValue
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.DirectionsRun
import androidx.compose.material.icons.automirrored.filled.MenuBook
import androidx.compose.material.icons.automirrored.filled.TrendingUp
import androidx.compose.material.icons.filled.AccessibilityNew
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Bedtime
import androidx.compose.material.icons.filled.DirectionsRun
import androidx.compose.material.icons.filled.EmojiEvents
import androidx.compose.material.icons.filled.Escalator
import androidx.compose.material.icons.filled.FitnessCenter
import androidx.compose.material.icons.filled.Flag
import androidx.compose.material.icons.filled.Height
import androidx.compose.material.icons.filled.Menu
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
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.FilledIconButton
import androidx.compose.material3.FilledIconToggleButton
import androidx.compose.material3.FilledTonalIconButton
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.ListItem
import androidx.compose.material3.ListItemDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import com.dev.habity.ViewModel.HabitDbViewmodel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    habitDbViewmodel: HabitDbViewmodel,
    onClick: () -> Unit
) {
    val habits by habitDbViewmodel.allHabit.observeAsState(emptyList())


    LaunchedEffect(Unit) {

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
                            println(habits)
                        }
                    ) {
                        Icon(
                            imageVector = Icons.Default.Menu,
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
        LazyColumn(
            modifier = modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(horizontal = 16.dp)
        ) {
            items(habits) {
                val icon = getIconByName(it.icon ?: "Star") // Default to "Star" if icon is null
                ListItem(
                    shadowElevation = 20.dp,
                    modifier = modifier
                        .padding(
                            vertical = 4.dp
                        )
                        .clip(RoundedCornerShape(16.dp)),
                    tonalElevation = 10.dp,

                    trailingContent = {
                        FilledIconButton(
                            onClick = { /* Handle click */ },
                            colors = IconButtonDefaults.iconButtonColors(
                                containerColor = MaterialTheme.colorScheme.primaryContainer
                            )
                        ) {
                            Icon(
                                imageVector = icon,
                                contentDescription = "Add",
                                tint = MaterialTheme.colorScheme.onPrimaryContainer
                            )
                        }
                    },
                    overlineContent = {
                        Text(
                            text = "Category: ${it.category } + ${it.id}",
                        )
                    },
                    headlineContent = {
                        Text(
                            text = it.title
                        )
                    },
                    supportingContent = {
                        Column(
                            modifier = modifier.fillMaxWidth()
                        ) {

                            Text(
                                text = it.description
                            )

                            LazyVerticalGrid(
                                columns = GridCells.Adaptive(minSize = 14.dp), // Size each box
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(100.dp)
                                    .padding(vertical = 4.dp)
                            ) {
                                items(100) { date ->
                                    Box(
                                        modifier = Modifier
                                            .padding(1.dp)
                                            .size(12.dp)
                                            .clip(RoundedCornerShape(4.dp))
                                            .background(
                                                MaterialTheme.colorScheme.onSurface
                                            )
                                    )
                                }
                            }

                        }
                    }
                )
            }
        }
    }
}



