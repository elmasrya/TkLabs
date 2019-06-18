package com.example.tklabs

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

val PREFS_FILENAME = "com.example.tklabs.prefs"
const val LOGIN_ID_EXTRA = "login_id"

class LoginActivity : AppCompatActivity(){

    var prefs: Prefs? = null
    lateinit var activity: Activity
    lateinit var bLogin: Button
    lateinit var appSDK: AppSDK;
    lateinit var etEmail: EditText
    lateinit var etPassword: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        activity = this;
        appSDK = AppSDK(activity)
        prefs = Prefs(activity)
        bLogin = findViewById(R.id.b_login)
        etEmail = findViewById(R.id.et_email)
        etPassword = findViewById(R.id.et_password)

        checkLogin()

        bLogin.setOnClickListener {
            appSDK.tryLogin(etEmail.text.toString(), etPassword.text.toString())
        }

    }

    fun checkLogin() {
        var loginID = prefs!!.loginID

        if (loginID > 0) {
            val homeActivity = Intent(activity, HomeActivity::class.java)
            homeActivity.putExtra(LOGIN_ID_EXTRA, loginID)
            activity.startActivity(homeActivity)
            activity.finish()
        } else {
            Toast.makeText(activity, "Please Login", Toast.LENGTH_LONG).show()
        }
    }
}
