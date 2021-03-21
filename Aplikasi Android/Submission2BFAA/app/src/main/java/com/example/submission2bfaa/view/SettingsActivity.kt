package com.example.submission2bfaa.view

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.provider.Settings
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.submission2bfaa.Helper.AlarmHelper
import com.example.submission2bfaa.R
import com.example.submission2bfaa.broadcast.AlarmReceiver
import kotlinx.android.synthetic.main.activity_settings.*
import java.util.*

class SettingsActivity : AppCompatActivity() {

    companion object {
        const val PREFS_NAME = "settings_pref"
        private const val DAILY = "daily"
        private const val ALARM_ID_REPEATING = 101
    }

    private lateinit var alarmReceiver: AlarmReceiver
    private lateinit var mSharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings)

        alarmReceiver = AlarmReceiver()
        mSharedPreferences = getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        if (supportActionBar != null) {
            supportActionBar?.title = "Settings"
        }

        btnChangeLanguages.setOnClickListener{

            val mIntent = Intent(Settings.ACTION_LOCALE_SETTINGS)
            startActivity(mIntent)
        }


        switchReminder.apply {
            isChecked = mSharedPreferences.getBoolean(DAILY,true)
            setOnCheckedChangeListener { _, isChecked ->
                setReminder(isChecked)
            }
        }
    }

    private fun setReminder(reminder: Boolean) {
        mSharedPreferences.edit().apply {
            putBoolean(DAILY,reminder)
        }.apply()

        applicationContext.let {
            if(reminder){
                AlarmHelper.createAlarm(
                    it,
                    "Favorite List",
                    "Let's Go find favorite list from gitHub!!",
                    ALARM_ID_REPEATING,
                    Calendar.getInstance().apply {
                        set(Calendar.HOUR_OF_DAY,9)
                        set(Calendar.MINUTE,0)
                        set(Calendar.SECOND,0)
                    }
                )

                Toast.makeText(applicationContext,"turn on",Toast.LENGTH_SHORT).show()
            }else{
                AlarmHelper.cancelAlarm(it, ALARM_ID_REPEATING)

                Toast.makeText(applicationContext,"turn Off",Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) finish()
        return super.onOptionsItemSelected(item)
    }
}
