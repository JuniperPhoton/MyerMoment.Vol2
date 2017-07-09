package com.juniperphoton.myermomentvol2

import android.app.Application
import com.juniperphoton.myermomentvol2.util.Logger

class App : Application() {
    override fun onCreate() {
        super.onCreate()
        Logger.init()
    }
}