package com.example.tklabs

import android.app.Activity
import android.content.Intent
import android.content.SharedPreferences
import android.widget.Toast

class SecureSafe {
    var prefs: SharedPreferences? = null

    fun storeLogin(activity: Activity, loginID: String): Boolean {
        prefs = activity.getSharedPreferences(PREFS_FILENAME, 0)
        val editor = prefs!!.edit()
        editor.putInt(LOGIN_ID_EXTRA, loginID.toInt())
        editor.apply()

        val homeActivity = Intent(activity, HomeActivity::class.java)
        homeActivity.putExtra(LOGIN_ID_EXTRA, loginID.toInt())
        activity.startActivity(homeActivity)
        activity.finish()

        return true
    }
}