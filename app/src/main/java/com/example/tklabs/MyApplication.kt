package com.example.tklabs

import android.app.Application

class MyApplication : Application() {
    companion object {
        var prefs: Prefs? = null
    }

    override fun onCreate() {
        prefs = Prefs(applicationContext)
        super.onCreate()
    }

    fun tryLogin() {

    }
}