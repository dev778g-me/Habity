package com.dev.habity.Model.Database

import android.graphics.drawable.Icon
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.TextUnitType
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import androidx.room.PrimaryKey
import java.sql.Date


@Entity(tableName = "habits")
data class Habit(
    
    @PrimaryKey(autoGenerate = true)
    val id : Long,  // id of the habit & also primary key
    val title : String, // title or name of the habit
    val description : String, // desc of the habit or details of the habit
    val category : String, // category of the habit
    val color: String?, // may be we can add color
    val icon : String?, // may be i can add icon (but i will need some type converters ..)
    val createdAt : Long = System.currentTimeMillis()  // time where the habit is created
)


//Completion table
@Entity(
    tableName = "completions",
    foreignKeys = [
        ForeignKey(
            entity = Habit::class,
            parentColumns = ["id"],
            childColumns = ["habitId"],
            onDelete = ForeignKey.CASCADE
        )
    ],
    indices = [Index(value = ["habitId"])]

)
data class Completion(
    @PrimaryKey(autoGenerate = true)
    val id : Long, // id of the completion of the habit
    val habitId : Long, // habit id for the foreign key
    val date: Long, // date where the habit started
    val amountOfCompletions : Int = 0 // amount of completion of the habit
)

//interval table
@Entity(
    tableName = "intervals",
    foreignKeys = [
        ForeignKey(
            entity = Habit::class,
            parentColumns = ["id"],
            childColumns = ["habitId"],
            onDelete = ForeignKey.CASCADE
        )

    ],
    indices = [Index(value = ["habitId"])]
)
data class IntervalEntity(
    @PrimaryKey
    val id : Long, // id of the interval entity
    val habitId: String, // this is the key i will be referring from the habit table primary key i.e id
    val startDate : Long, // start date of the habit
    val endDate: Long? = null, // end date of the habit
    val type : String, // type of the habit
    val requiredNumberOfCompletion: Int?, // required number of completion (weekly, monthly , yearly)
    val requiredNumberOfCompletionPerDay: Int?, // required number of the completion per day (like one or two completion per day)
    val streakType: String, // type of the streak of the habit
    val unitType: String, // type of the unit type -- may be i will figure it out

)