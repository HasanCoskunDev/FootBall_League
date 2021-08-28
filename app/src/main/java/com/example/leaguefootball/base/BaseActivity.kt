package com.example.leaguefootball.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding

abstract class BaseActivity<DB:ViewDataBinding> : AppCompatActivity() {

    abstract val layoutRes: Int
    abstract fun onCreated()
    abstract fun listener()

    protected lateinit var binding: DB

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layoutRes)

        //default toolbari kapatmak icin
        supportActionBar?.hide()

        binding = DataBindingUtil.setContentView(this, layoutRes)

        onCreated()
        listener()
    }
}