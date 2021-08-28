package com.example.leaguefootball.ui.main.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.leaguefootball.R
import com.example.leaguefootball.base.BaseFragment
import com.example.leaguefootball.databinding.FragmentWeekMatchesBinding
import com.example.leaguefootball.room.models.WeekEntity
import com.example.leaguefootball.ui.adapter.MatchesAdapter

class WeekMatchesFragment(val weekEntity: WeekEntity) : BaseFragment<FragmentWeekMatchesBinding>() {


    override val layoutId: Int
        get() = R.layout.fragment_week_matches

    override fun onCreated() {
        setAdapter()
    }

    override fun listener() { //To change body of created functions use File | Settings | File Templates.
    }

    private fun setAdapter() {
        val adapter =
            MatchesAdapter(ArrayList(leagueDao.getMatchesWithWeekId(weekEntity.id)), leagueDao)
        binding.rvMatches.adapter = adapter
    }
}