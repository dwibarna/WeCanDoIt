package com.example.submissionone.view

import android.content.Intent
import android.os.Bundle
import android.provider.Settings
import androidx.appcompat.app.AppCompatActivity
import com.example.submissionone.R
import com.example.submissionone.databinding.ActivitySettingBinding
import com.example.submissionone.view.fragment.MyPreferenceFragment

class SettingActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySettingBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySettingBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportFragmentManager.beginTransaction().add(R.id.constrainsSettings, MyPreferenceFragment()).commit()
        clickToChangeLanguage()
    }
    private fun clickToChangeLanguage() {
        binding.btnChangeLanguage.setOnClickListener {
            val menuIntent = Intent(Settings.ACTION_LOCALE_SETTINGS)
            startActivity(menuIntent)
        }
    }
}