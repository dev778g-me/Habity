package com.dev.habity.View.Screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.rounded.Add
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.FilledIconButton
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ListItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.dev.habity.ViewModel.HabitDbViewmodel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    habitDbViewmodel: HabitDbViewmodel,
    onClick: () -> Unit
) {
    val habits = habitDbViewmodel.allhabit.observeAsState(emptyList())


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
    ){
        innerPadding ->
        LazyColumn(
            modifier = modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {
            items(habits.value.toList()) {
                ListItem(
                    overlineContent = {
                        Text(text = it.category)
                    },
                    leadingContent = {
                        FilledIconButton(
                            onClick = {}
                        ) {

                            Icon(imageVector = Icons.Default.Menu,contentDescription = null)
                        }
                    },
                    headlineContent = { Text(text = it.title) },
                    supportingContent = {
                        Text(
                            text = it.description
                        )
                    }

                )
            }
        }
    }
}