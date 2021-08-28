package com.example.leaguefootball.app

import android.app.Application
import android.content.Context
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent
import androidx.room.Room
import com.example.leaguefootball.room.LeagueDao
import com.example.leaguefootball.room.LeagueDatabase

class BaseApplication : Application() {

    lateinit var leagueDao : LeagueDao

    companion object {
        lateinit var instance: BaseApplication
    }

    override fun attachBaseContext(base: Context) {
        super.attachBaseContext(base)
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
        leagueDao = Room.databaseBuilder(
            applicationContext,
            LeagueDatabase::class.java, "LeagueDatabase"
        ).allowMainThreadQueries().build().leagueDao()
    }
}