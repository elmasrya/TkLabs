package com.example.tklabs

import android.content.Context
import android.content.SharedPreferences

class Prefs (context: Context) {
    val PREFS_FILENAME = "com.example.tklabs.prefs"
    val LOGIN_ID = "login_id"
    val prefs: SharedPreferences = context.getSharedPreferences(PREFS_FILENAME, 0);

    var loginID: Int
        get() = prefs.getInt(LOGIN_ID, 0)
        set(value) = prefs.edit().putInt(LOGIN_ID, value).apply()
}