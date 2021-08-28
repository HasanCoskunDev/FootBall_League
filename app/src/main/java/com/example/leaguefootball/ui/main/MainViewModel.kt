package com.example.leaguefootball.ui.main

import androidx.lifecycle.ViewModel
import com.example.leaguefootball.app.BaseApplication
import com.example.leaguefootball.room.models.WeekEntity

class MainViewModel : ViewModel() {

    val leagueDao = BaseApplication.instance.leagueDao

    fun getTeams() {

    }

    fun getWeeks(): ArrayList<WeekEntity> {
        return ArrayList(leagueDao.getWeeks())
    }

}