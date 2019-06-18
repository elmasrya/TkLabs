package com.example.tklabs

import org.json.JSONArray
import org.json.JSONObject

class ValidationService {
    lateinit var jsonArray : JSONArray

    fun userValidation(email: String, password: String,incomingjsonArray: JSONArray): String {
        var validUser: String = ""
        jsonArray = incomingjsonArray

        for (i in 0..(jsonArray.length() - 1)) {
            val item = jsonArray.getJSONObject(i)

            var checkEmail = item.getString("email")

            if (checkEmail.equals(email)) {
                var checkPassword = item.getString("password")

                if (checkPassword.equals(password) && checkPassword.length >= 8) {
                    validUser = item.toString()
                    break
                } else {
                    validUser = "wrong passoword or minimum is not met"
                }
            } else {
                validUser = "Invalid Login "
            }
        }

        return validUser
    }
}