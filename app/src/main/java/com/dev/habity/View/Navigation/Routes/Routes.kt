package com.dev.habity.View.Navigation.Routes

import kotlinx.serialization.Serializable


@Serializable
sealed class Routes (val routes: String) {
    @Serializable
    data object HomeScreen : Routes("home")

    @Serializable
    data object AddHabitScreen : Routes("add_habit")


}