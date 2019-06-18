package com.example.tklabs

import android.app.Activity
import android.util.Log
import org.json.JSONObject
import java.io.IOException


class AppSDK(activity: Activity) {
    var activity: Activity = activity

    fun tryLogin() {

        var jsonObject: JSONObject = JSONObject(loadJSONFromAsset())

        Log.d("hey", jsonObject.toString())
    }

    fun loadJSONFromAsset(): String {
        var json: String = ""
        try {
            val `is` = activity.getAssets().open("users.json")
            val size = `is`.available()
            val buffer = ByteArray(size)
            `is`.read(buffer)
            `is`.close()
            json = String(buffer, charset("UTF-8"))
        } catch (ex: IOException) {
            ex.printStackTrace()
        }

        return json
    }

}