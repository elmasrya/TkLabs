package com.example.tklabs

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class HomeActivity : AppCompatActivity() {
    lateinit var tvLoginID: TextView
    var loginID: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        loginID = intent.getIntExtra(LOGIN_ID_EXTRA, 0)
        tvLoginID = findViewById(R.id.tv_login_id)




    }
}