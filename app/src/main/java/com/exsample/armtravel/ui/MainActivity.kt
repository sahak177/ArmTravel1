package com.exsample.armtravel.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.exsample.armtravel.R
import com.exsample.armtravel.ui.launch.LaunchActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        startActivity(Intent(this@MainActivity, LaunchActivity::class.java))
        finish()
    }
}