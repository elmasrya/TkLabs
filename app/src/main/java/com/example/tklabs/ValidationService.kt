package com.example.tklabs

import org.json.JSONArray
import org.json.JSONObject

class ValidationService {
    lateinit var jsonArray : JSONArray

    fun emailValidation(email: String, incomingjsonArray: JSONArray): Boolean {
        jsonArray = incomingjsonArray

        for (i in 0..(jsonArray.length() - 1)) {
            val item = jsonArray.getJSONObject(i)

            var checkEmail = item.getString("email")

            if (checkEmail.equals(email)) return true
        }

        return false
    }

    fun passwordValidation(password: String): Boolean {
        for (i in 0..(jsonArray.length() - 1)) {
            val item = jsonArray.getJSONObject(i)

            var checkPassword = item.getString("password")

            if (checkPassword.equals(password) && password.length >= 8) return true
        }

        return false
    }
}