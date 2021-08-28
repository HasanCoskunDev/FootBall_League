package com.example.leaguefootball.ui.main

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.leaguefootball.room.models.WeekEntity
import com.example.leaguefootball.ui.main.fragment.WeekMatchesFragment

class WeeksViewPagerAdapter(
    fa: FragmentActivity, private val weekList: ArrayList<WeekEntity>
) :
    FragmentStateAdapter(fa) {

    override fun getItemCount(): Int = weekList.size

    override fun createFragment(position: Int): Fragment {
        return WeekMatchesFragment(weekList[position])
    }
}