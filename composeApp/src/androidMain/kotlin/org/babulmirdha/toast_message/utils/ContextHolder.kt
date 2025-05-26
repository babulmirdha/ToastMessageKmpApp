package org.babulmirdha.toast_message.utils

import android.annotation.SuppressLint
import android.content.Context

@SuppressLint("StaticFieldLeak")
object ContextHolder {
    lateinit var current: Context
        private set

    fun init(context: Context) {
        current = context.applicationContext
    }
}

