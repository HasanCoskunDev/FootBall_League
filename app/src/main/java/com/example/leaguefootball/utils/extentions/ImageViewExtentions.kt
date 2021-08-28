package com.example.leaguefootball.utils.extentions

import android.content.Context
import android.widget.ImageView
import com.bumptech.glide.Glide

fun ImageView.load(ctx:Context,url: String) {
    if (url.isNotEmpty()){
        Glide.with(ctx).load(url).centerCrop().into(this)
    }
}