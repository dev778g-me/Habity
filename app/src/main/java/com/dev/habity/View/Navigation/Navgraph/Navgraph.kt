package com.dev.habity.View.Navigation.Navgraph


import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavGraph
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.dev.habity.View.Navigation.Routes.Routes
import com.dev.habity.View.Screens.AddHabitScreen
import com.dev.habity.View.Screens.AnalyticsScreen

import com.dev.habity.View.Screens.HomeScreen
import com.dev.habity.ViewModel.HabitDbViewmodel
import dagger.hilt.android.qualifiers.ApplicationContext

@Composable
fun NavGraph(
    habitDbViewmodel: HabitDbViewmodel,
    @ApplicationContext context: android.content.Context,
) {

    val navController = rememberNavController()

    NavHost(
        navController =  navController,
        startDestination = Routes.HomeScreen.routes
    ) {
        composable(Routes.HomeScreen.routes) {
            HomeScreen(
                navController = navController,
                context = context

            )
        }

        composable(Routes.AddHabitScreen.routes) {
            AddHabitScreen(
                onNavigation = {
                    navController.navigateUp()
                }
            )
        }

        composable(Routes.AnalyticsScreen.routes) {
            AnalyticsScreen(
                navController = navController
            )
        }


    }

}