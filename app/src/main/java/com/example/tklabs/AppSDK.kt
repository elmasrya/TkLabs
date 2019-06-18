package com.example.tklabs

import android.app.Activity
import android.util.Log
import org.json.JSONArray
import org.json.JSONObject
import java.io.IOException


class AppSDK(activity: Activity) {
    var activity: Activity = activity
    lateinit var jsonArrayUsers: JSONArray

    suspend fun suspendTryLogin(email: String, password: String) : String{
        Log.d("hey", password)

        var loginResponse: String = ""
        var validEmail: Boolean = false
        var validPassword: Boolean = false

        var jsonObject: JSONObject = JSONObject(loadJSONFromAsset())
        jsonArrayUsers = jsonObject.getJSONArray("users")

        var validationService: ValidationService = ValidationService()

        validEmail = validationService.emailValidation( email,jsonArrayUsers)

        if (validEmail) {
            validPassword = validationService.passwordValidation(password)

            if (validPassword) {
                loginResponse = "Login Successful"
            } else {
                loginResponse = "Invalid Password or Minimum length not met"
            }
        }

        return  loginResponse
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