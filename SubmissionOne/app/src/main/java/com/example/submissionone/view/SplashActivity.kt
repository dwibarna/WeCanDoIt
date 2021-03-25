package com.example.submissionone.view

import android.content.Intent
import android.os.Bundle
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import com.example.submissionone.R

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)
        setSplash()
    }

    private fun setSplash() {
        window.setFlags(
            WindowManager.LayoutParams.ANIMATION_CHANGED,
            WindowManager.LayoutParams.FIRST_APPLICATION_WINDOW
        )
        android.os.Handler(mainLooper).postDelayed({
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        },3000)
    }
}