package com.example.tklabs

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

const val LOGIN_ID_EXTRA = "com.example.tklabs.LoginID"

class LoginActivity : AppCompatActivity() {

    var prefs: Prefs? = null
    lateinit var activity: Activity
    lateinit var bLogin: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        activity = this;
        prefs = Prefs(activity)
        bLogin = findViewById(R.id.b_login)

        checkLogin()

        bLogin.setOnClickListener{
            
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

    suspend fun loadUser() {

    }

    fun fetchUser() {

    }

}
