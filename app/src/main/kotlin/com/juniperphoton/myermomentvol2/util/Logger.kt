package com.juniperphoton.myermomentvol2.util

import android.util.Log
import com.juniperphoton.myermomentvol2.BuildConfig

object Logger {
    private var isDebugMode = true

    fun init() {
        isDebugMode = BuildConfig.DEBUG
    }

    fun info(tag: String, info: String) {
        if (!isDebugMode) {
            return
        }
        Log.i(tag, info)
    }

    fun warn(tag: String, info: String) {
        if (!isDebugMode) {
            return
        }
        Log.w(tag, info)
    }

    fun error(tag: String, info: String) {
        if (!isDebugMode) {
            return
        }
        Log.e(tag, info)
    }

    fun debug(tag: String, info: String) {
        if (!isDebugMode) {
            return
        }
        Log.d(tag, info)
    }
}