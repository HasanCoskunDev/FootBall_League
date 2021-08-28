package com.example.leaguefootball.ui.fixture

import androidx.lifecycle.ViewModel
import com.example.leaguefootball.app.BaseApplication
import com.example.leaguefootball.room.models.MatchEntity
import com.example.leaguefootball.room.models.TeamEntity
import com.example.leaguefootball.room.models.WeekEntity

class FixtureViewModel : ViewModel() {

    val leagueDao = BaseApplication.instance.leagueDao

    fun getTeams(): ArrayList<TeamEntity> {
        return ArrayList(leagueDao.getTeams())
    }

    fun getTeamCount(): Int {
        return leagueDao.getTeamCount()
    }

    fun addTeams(model: TeamEntity) {
        leagueDao.addTeam(model)
    }

    fun addWeek(model: WeekEntity) {
        leagueDao.addWeek(model)
    }

    fun getWeeks(): ArrayList<WeekEntity> {
        return ArrayList(leagueDao.getWeeks())
    }

    fun addMatch(model: MatchEntity) {
        leagueDao.addMatch(model)
    }

    fun resetRoom() {
        leagueDao.deleteMatch()
        leagueDao.deleteTeam()
        leagueDao.deleteWeek()
    }
}