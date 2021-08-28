package com.example.leaguefootball.room.models

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.leaguefootball.base.BaseModel

@Entity(tableName = "TeamTable")
data class TeamEntity(
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0,
    var name: String,
    var photoUrl: String,
) : BaseModel()