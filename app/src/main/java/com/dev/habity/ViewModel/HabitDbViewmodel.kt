package com.dev.habity.ViewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dev.habity.Model.Database.Habit
import com.dev.habity.Model.Database.HabitDatabase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch
import javax.inject.Inject
@HiltViewModel
class HabitDbViewmodel @Inject constructor(
 val  db : HabitDatabase

) : ViewModel(){
   val habitDao = db.HabitDao()
    var allhabit: LiveData<List<Habit>> = habitDao.getAllHabits()
    init {
        viewModelScope.launch {
          allhabit = pro()
        }
       // pro()
    }
    // funtion to fetch all habits from the database
    fun pro () : LiveData<List<Habit>> {
      val habit = habitDao.getAllHabits()
        return  habit
    }
}