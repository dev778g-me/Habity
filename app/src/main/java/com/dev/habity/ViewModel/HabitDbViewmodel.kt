package com.dev.habity.ViewModel

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dev.habity.Model.Database.Completion
import com.dev.habity.Model.Database.Habit
import com.dev.habity.Model.Database.HabitDatabase
import com.dev.habity.Model.Repo.HabitRepo
import com.dev.habity.service.notification.HabityNotificationService
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch
import java.lang.Exception
import javax.inject.Inject
@HiltViewModel
class HabitDbViewmodel @Inject constructor(
  private val habitRepo: HabitRepo,
  private val habityNotificationService: HabityNotificationService
) : ViewModel(){

    val allHabit : LiveData<List<Habit>> = habitRepo.allHabits
    fun getAllCompletions(habitId: Long): LiveData<List<Completion>> {
        return habitRepo.fetchCompletions(
            habitId = habitId
        )
        print(habitRepo.fetchCompletions(habitId).value)
    }
     // function to get all the habits

//    fun fetchCompletions(habitId: Long) : LiveData<List<Completion>> {
//        viewModelScope.launch(Dispatchers.IO) {
//            return@launch habitRepo.fetchCompletions(
//                habitId = habitId
//            )
//        }
//    }
    fun insertHabitWithCompletions(habit: Habit,){
        viewModelScope.launch(Dispatchers.IO) {
           val habitId= habitRepo.insertHabit(
               habit = habit
           )
            print(habitId)
           habitRepo.insertCompletions(
               completion = Completion(
                   id = 0,
                   habitId = habitId,
                   date = System.currentTimeMillis()
               )
           )
        }
    }

    // function to insert a habit into the database

    fun insertHabit(habit: Habit){
        viewModelScope.launch(Dispatchers.IO) {
            habitRepo.insertHabit(
                habit =habit
            )
        }
    }


    // function to delete a habit from the database

    fun deleteHabit(habit: Habit){
        viewModelScope.launch(Dispatchers.IO) {
            habitRepo.deleteHabit(
                habit = habit
            )
        }
    }


    // function to insert a completion for a habit into the database
    fun insertCompletion(completion: Completion){
        viewModelScope.launch(Dispatchers.IO) {
            habitRepo.insertCompletions(
                completion = completion
            )
        }
    }


    fun getCompletions(habitId: Long) : LiveData<List<Completion>>{
        return habitRepo.fetchCompletions(
            habitId = habitId
        )
    }



    // function to show the notification
    fun showNotification(
        context: Context
    ) {
       try {
           habityNotificationService.showNotification(
               context
           )
       }catch (e: kotlin.Exception){
           println(e.message)
       }
    }
}