package com.dev.habity.ViewModel

import android.content.Context
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccessibilityNew
import androidx.compose.material.icons.filled.Bedtime
import androidx.compose.material.icons.filled.Code
import androidx.compose.material.icons.filled.DirectionsRun
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
import androidx.compose.material.icons.filled.School
import androidx.compose.material.icons.filled.SelfImprovement
import androidx.compose.material.icons.filled.SmokingRooms
import androidx.compose.material.icons.filled.Spa
import androidx.compose.material.icons.filled.Straighten
import androidx.compose.material.icons.filled.Timeline
import androidx.compose.material.icons.filled.TrendingUp
import androidx.compose.ui.graphics.drawscope.DrawContext
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.glance.appwidget.GlanceAppWidgetManager
import androidx.glance.appwidget.updateAll
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dev.habity.View.HabityWidget.HabityListWidget.HabityListWidget
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import java.time.LocalTime
import javax.inject.Inject


@HiltViewModel
class HabityStateViewModel @Inject constructor(

) : ViewModel(){

    // variable for habit name
    private val _habitName = MutableStateFlow("")
    val habitName = _habitName.asStateFlow()


    // function for habit name
    fun onHabitNameChanged (name : String) {
        _habitName.value = name
    }
    val isHabitNameValid = habitName.map {
        it.isNotEmpty()
    }.stateIn(
        viewModelScope,
        SharingStarted.WhileSubscribed(5000),
        false
    )

    // variable for habit description
    private val _habitDescription = MutableStateFlow("")
    val habitDescription = _habitDescription.asStateFlow()

    //function for habit description
    fun onHabitDescriptionChanged (description : String) {
        _habitDescription.value = description
    }

    val isHabitDescriptionValid = habitDescription.map {
        it.isNotEmpty()
    }.stateIn(
    viewModelScope,
    SharingStarted.WhileSubscribed(5000),
    false
    )

   // variable for is habiit and description are empty or not
    val canAddHabit = combine(
         isHabitNameValid,
        isHabitDescriptionValid
    ) {
      isHabitNameValid  ,isHabitDescriptionValid ->

        isHabitNameValid && isHabitDescriptionValid

    }.stateIn(
        viewModelScope,
        SharingStarted.WhileSubscribed(5000),
        false
    )


    // variable for the number of the completions

  private  val _numberOfCompletion = MutableStateFlow(1)
    val numberOFCompletion = _numberOfCompletion.asStateFlow()

    // function for incrementing the number of completions
    fun incrementNumberOfCompletion() {
        _numberOfCompletion.value ++
    }

    // functions for decrementing the number of completions
    fun decrementNumberOfCompletion(){
       _numberOfCompletion.value --
    }


    // map for the habit category
    val categoryIconMap : Map<String, ImageVector> = mapOf(
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


    private val _habitCategory = MutableStateFlow<String>( "Other")
    val habitCategory = _habitCategory.asStateFlow()


    // function for setting the habit category
    fun setHabitCategory(category: String) {
        _habitCategory.value = category
    }


    // map for the icon of the category

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
    private val _habitIcon = MutableStateFlow<String>("FitnessCenter")
    val habitIcon = _habitIcon.asStateFlow()

    // function for setting the habit icon
    fun setHabitIcon(icon: String) {
        _habitIcon.value = icon
    }


    // list for streak goals
    val streakOptions = listOf("Daily", "Weekly", "Monthly")

    private val _streakGoal = MutableStateFlow<String>("Daily")
    val streakGoal = _streakGoal.asStateFlow()

    fun setStreakGoal(goal: String) {
        _streakGoal.value = goal
    }



    // variable to hold state of the time
    val timeOptionsMap = mapOf(
        "Morning" to LocalTime.of(9, 0),        // 9:00 AM
        "Afternoon" to LocalTime.of(13, 0),     // 1:00 PM
        "Evening" to LocalTime.of(17, 0),       // 5:00 PM
        "Night" to LocalTime.of(20, 0),         // 8:00 PM
        "Before Bed" to LocalTime.of(22, 0),    // 10:00 PM
        "Custom" to LocalTime.of(0,0)          // Will be user-defined
    )


    private val _timeOptions = MutableStateFlow("Morning")
    val timeOptions = _timeOptions.asStateFlow()

    private val _customTime = MutableStateFlow<LocalTime?>(null)
    val customTime = _customTime.asStateFlow()
    fun changeTime(time: String){
        _timeOptions.value = time
    }
    fun setCustomTime(time: String){
        _timeOptions.value = time
        //timeOptionsMap.entries[5]
    }




}
