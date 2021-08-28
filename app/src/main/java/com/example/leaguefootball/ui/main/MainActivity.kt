package com.example.leaguefootball.ui.main

import androidx.lifecycle.ViewModelProvider
import com.example.leaguefootball.R
import com.example.leaguefootball.base.BaseActivity
import com.example.leaguefootball.databinding.ActivityMainBinding
import com.google.android.material.tabs.TabLayoutMediator


class MainActivity : BaseActivity<ActivityMainBinding>() {

    lateinit var viewModel : MainViewModel

    override val layoutRes: Int
        get() = R.layout.activity_main

    override fun onCreated() {
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        setWeekAdapter()
    }

    override fun listener() {
    }

    //week view pager adapteri burada olusturuyorum
    private fun setWeekAdapter() {
        val weeks = viewModel.getWeeks()
        binding.vpMatches.adapter = WeeksViewPagerAdapter(this, weeks)
        TabLayoutMediator(binding.tlWeeks, binding.vpMatches) { tab, position ->
            tab.text = weeks[position].name
        }.attach()
    }
}
