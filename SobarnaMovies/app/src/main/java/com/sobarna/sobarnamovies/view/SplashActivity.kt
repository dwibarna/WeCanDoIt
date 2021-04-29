package com.sobarna.sobarnamovies.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.WindowManager
import com.sobarna.sobarnamovies.R

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        startSplash()
    }

    private fun startSplash() {
        window.setFlags(
                WindowManager.LayoutParams.ANIMATION_CHANGED,
                WindowManager.LayoutParams.FIRST_APPLICATION_WINDOW
        )
        Handler(mainLooper).postDelayed({
            val intent = Intent(this,MainActivity::class.java)
            startActivity(intent)
            finish()
        },3000)
    }
}