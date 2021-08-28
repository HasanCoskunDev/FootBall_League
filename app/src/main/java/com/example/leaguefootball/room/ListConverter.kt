package com.example.leaguefootball.room


import androidx.room.TypeConverter
import com.example.leaguefootball.room.models.MatchEntity
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.util.*

class ListConverter {
    @TypeConverter
    fun restoreList(listOfString: String): ArrayList<MatchEntity> {
        return Gson().fromJson(
            listOfString,
            object : TypeToken<ArrayList<MatchEntity>>() {}.type
        )
    }

    @TypeConverter
    fun saveList(listOfString: ArrayList<MatchEntity>): String {
        return Gson().toJson(listOfString)
    }
}