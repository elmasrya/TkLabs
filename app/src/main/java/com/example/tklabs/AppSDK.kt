package com.example.tklabs

import android.app.Activity
import android.util.Log
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.json.JSONArray
import org.json.JSONObject
import java.io.IOException


class AppSDK(activity: Activity) {
    var activity: Activity = activity
    lateinit var jsonArrayUsers: JSONArray
    var validationService: ValidationService = ValidationService()
    var webService: WebService = WebService()

    fun tryLogin(email: String, password: String) : String {
        var loginID: String = ""
        var validUser: String = ""

        var jsonObject: JSONObject = JSONObject(loadJSONFromAsset())
        jsonArrayUsers = jsonObject.getJSONArray("users")

        GlobalScope.launch(Dispatchers.IO) {
            validUser = withContext(Dispatchers.IO) {validationService.userValidation(email, password, jsonArrayUsers)}
            loginID = withContext(Dispatchers.IO) {webService.login(validUser, activity)}
        }

        return loginID
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