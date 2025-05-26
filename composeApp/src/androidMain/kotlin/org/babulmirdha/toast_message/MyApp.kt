package org.babulmirdha.toast_message

import android.app.Application
import org.babulmirdha.toast_message.utils.ContextHolder

class MyApp : Application() {
    override fun onCreate() {
        super.onCreate()
        ContextHolder.init(this)
    }
}
