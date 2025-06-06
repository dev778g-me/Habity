package com.dev.habity.Model.Database

import androidx.room.TypeConverter
import java.time.LocalTime
import java.time.format.DateTimeFormatter

class HabityConverters {

    @TypeConverter
    fun fromIntToString (intList: List<Int>) : String{
       return intList.joinToString(",")
    }

    @TypeConverter
    fun toIntList(data: String): List<Int> {
        if (data.isEmpty()) {
       return emptyList<Int>()
        } else {
          return  data.split(",").map {
                it.toInt()
            }
        }
    }


    @TypeConverter
    fun fromLocalTime(time: LocalTime) : String {
        return time.format(DateTimeFormatter.ofPattern("HH:mm:a"))
    }

     @TypeConverter
    fun toLocalTime(time: String) : LocalTime {
        return LocalTime.parse(time, DateTimeFormatter.ofPattern("HH:mm:a"))
    }

}