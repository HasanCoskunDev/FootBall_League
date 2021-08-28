package com.example.leaguefootball.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.leaguefootball.room.models.MatchEntity
import com.example.leaguefootball.room.models.TeamEntity
import com.example.leaguefootball.room.models.WeekEntity

@Dao
interface LeagueDao {

    //Weak
    @Insert
    fun addWeek(vararg messageEntity: WeekEntity)

    @Query("select * from WeekTable where :id == id")
    fun getWeek(id: String): WeekEntity?

    @Query("select * from WeekTable")
    fun getWeeks(): List<WeekEntity>

    @Update
    fun updateWeek(order: WeekEntity?)

    @Query("DELETE FROM WeekTable where :id == id")
    fun deleteWeek(id: String)

    @Query("DELETE FROM WeekTable")
    fun deleteWeek()

    //Team
    @Insert
    fun addTeam(vararg messageEntity: TeamEntity)

    @Query("select * from TeamTable where :id == id")
    fun getTeam(id: Int): TeamEntity?

    @Query("select * from TeamTable")
    fun getTeams(): List<TeamEntity>

    @Query("select count(id) from TeamTable")
    fun getTeamCount(): Int

    @Update
    fun updateTeam(order: TeamEntity?)

    @Query("DELETE FROM TeamTable where :id == id")
    fun deleteTeam(id: String)

    @Query("DELETE FROM TeamTable")
    fun deleteTeam()

    //Match
    @Insert
    fun addMatch(vararg messageEntity: MatchEntity)

    @Query("select * from MatchTable where :id == id")
    fun getMatch(id: String): MatchEntity?

    @Query("select * from MatchTable")
    fun getMatches(): List<MatchEntity>

    @Query("select * from MatchTable where :weekId == weekId")
    fun getMatchesWithWeekId(weekId: Int): List<MatchEntity>

    @Query("select count(id) from TeamTable")
    fun getMatchCount(): Int

    @Update
    fun updateMatch(order: MatchEntity?)

    @Query("DELETE FROM MatchTable where :id == id")
    fun deleteMatch(id: String)

    @Query("DELETE FROM MatchTable")
    fun deleteMatch()

}