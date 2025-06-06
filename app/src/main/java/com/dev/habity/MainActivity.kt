package com.dev.habity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import com.dev.habity.View.Navigation.Navgraph.NavGraph
import com.dev.habity.View.Screens.HomeScreen
import com.dev.habity.ViewModel.HabitDbViewmodel
import com.dev.habity.service.alarmmanger.HabityAlarmManager

import com.example.compose.HabityTheme
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.HiltAndroidApp


@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {

            val viewmodel : HabitDbViewmodel = hiltViewModel()
            HabityTheme{
                NavGraph(
                    viewmodel,
                    context = this
                )
            }
        }
    }
}

