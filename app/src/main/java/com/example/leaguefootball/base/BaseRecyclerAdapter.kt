package com.example.leaguefootball.base

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView

abstract class BaseRecyclerAdapter<T, DB : ViewDataBinding> :
    RecyclerView.Adapter<BaseRecyclerAdapter.ViewHolder>() {

    abstract val layoutRes: Int
    abstract val arrayList: ArrayList<T>
    abstract fun bindView(binding: DB, currentData: T, position: Int)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding: DB = DataBindingUtil.inflate(LayoutInflater.from(parent.context),layoutRes, parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int = arrayList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        try {
            val currentData: T = arrayList[position]
            bindView(holder.currentBinding as DB, currentData, position)
        } catch (e: Exception) {

        }
    }

    class ViewHolder(binding: ViewDataBinding) : RecyclerView.ViewHolder(binding.root) {
        val currentBinding = binding
    }
}