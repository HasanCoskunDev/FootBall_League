package com.example.leaguefootball.room.models

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.leaguefootball.base.BaseModel

@Entity(tableName = "MatchTable")
data class MatchEntity(
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0,
    var hostScore: Int,
    var guestScore: Int,
    var hostTeamId: Int,
    var guestTeamId: Int,
    var weekId: Int
) : BaseModel()