package com.dev.habity.View.Screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(modifier: Modifier = Modifier,onClick: () -> Unit) {
    Scaffold (
        topBar = {
            CenterAlignedTopAppBar(
                navigationIcon = {
                    IconButton(
                        onClick = {}
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
            FloatingActionButton(onClick = {
                onClick.invoke()
            }) {
                Icon(imageVector = Icons.Default.Add, contentDescription = null)
            }
        }
    ){
        innerPadding ->

        Column (
            modifier = Modifier.fillMaxSize()
                .padding(innerPadding)
        ){

        }
    }
}