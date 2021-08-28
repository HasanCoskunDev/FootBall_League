package com.example.leaguefootball.utils.extentions

import android.app.Activity
import android.content.Context
import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.Point
import android.graphics.Rect
import android.graphics.drawable.BitmapDrawable
import android.graphics.drawable.Drawable
import android.os.Build
import android.view.Display
import android.view.View
import android.view.WindowManager
import android.view.inputmethod.InputMethodManager
import androidx.fragment.app.FragmentActivity
import com.example.leaguefootball.app.BaseApplication
import java.lang.reflect.InvocationTargetException


fun View.show() {
    if (this.visibility != View.VISIBLE)
        this.visibility = View.VISIBLE
}

fun View.hide() {
    if (this.visibility != View.INVISIBLE)
        this.visibility = View.INVISIBLE
}

fun View.gone() {
    if (this.visibility != View.GONE)
        this.visibility = View.GONE
}