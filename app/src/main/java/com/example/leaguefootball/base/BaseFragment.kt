package com.example.leaguefootball.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import com.example.leaguefootball.app.BaseApplication

abstract class BaseFragment<DB : ViewDataBinding> : androidx.fragment.app.Fragment() {

    val leagueDao = BaseApplication.instance.leagueDao

    protected lateinit var binding: DB

    abstract val layoutId: Int
    abstract fun onCreated()
    abstract fun listener()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, layoutId, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        onCreated()
        listener()
    }
}