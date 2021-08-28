package com.example.leaguefootball.room.models

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.example.leaguefootball.base.BaseModel
import com.example.leaguefootball.room.ListConverter

@Entity(tableName = "WeekTable")
@TypeConverters(ListConverter::class)
data class WeekEntity(
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0,
    var name: String,
    var matches: ArrayList<MatchEntity>
) : BaseModel()