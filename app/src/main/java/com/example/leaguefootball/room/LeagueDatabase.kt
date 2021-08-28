package com.example.leaguefootball.room

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.leaguefootball.room.models.MatchEntity
import com.example.leaguefootball.room.models.TeamEntity
import com.example.leaguefootball.room.models.WeekEntity

@Database(
    entities = [TeamEntity::class,  MatchEntity::class,  WeekEntity::class],
    version = 1,
    exportSchema = false
)
@TypeConverters(
    ListConverter::class
)
abstract class LeagueDatabase(): RoomDatabase() {
    abstract fun leagueDao(): LeagueDao
}