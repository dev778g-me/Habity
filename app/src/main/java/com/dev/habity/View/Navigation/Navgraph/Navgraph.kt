package com.dev.habity.View.Navigation.Navgraph


import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavGraph
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.dev.habity.View.Navigation.Routes.Routes
import com.dev.habity.View.Screens.AddHabitScreen

import com.dev.habity.View.Screens.HomeScreen
import com.dev.habity.ViewModel.HabitDbViewmodel

@Composable
fun NavGraph(
    habitDbViewmodel: HabitDbViewmodel
) {

    val navController = rememberNavController()

    NavHost(
        navController =  navController,
        startDestination = Routes.HomeScreen.routes
    ) {
        composable(Routes.HomeScreen.routes) {
            HomeScreen(
                onClick = {
                    navController.navigate(Routes.AddHabitScreen.routes)
                },
                habitDbViewmodel = habitDbViewmodel
            )
        }

        composable(Routes.AddHabitScreen.routes) {
            AddHabitScreen(
                onNavigation = {
                    navController.navigateUp()
                }
            )
        }


    }

}