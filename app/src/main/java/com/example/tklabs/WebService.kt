package com.example.tklabs

import android.app.Activity
import org.json.JSONObject

class WebService {

    fun login(userData: String): String {
        val jsonObject = JSONObject(userData)
        return jsonObject.getString("id")
    }
}