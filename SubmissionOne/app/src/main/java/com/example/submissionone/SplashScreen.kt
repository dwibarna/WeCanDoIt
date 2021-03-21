package com.example.submissionone

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Looper
import android.view.WindowManager
import java.util.logging.Handler

class SplashScreen : AppCompatActivity() {
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

        android.os.Handler().postDelayed({
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        },3000)

    }
}