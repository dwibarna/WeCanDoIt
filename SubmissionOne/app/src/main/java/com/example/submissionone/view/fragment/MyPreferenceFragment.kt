package com.example.submissionone.view.fragment

import android.app.AlarmManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import androidx.preference.PreferenceFragmentCompat
import androidx.preference.SwitchPreference
import com.example.submissionone.R
import com.example.submissionone.broadcast.ReminderReceiver
import java.util.*

class MyPreferenceFragment:PreferenceFragmentCompat(),
    SharedPreferences.OnSharedPreferenceChangeListener {
    private lateinit var switchPreference: SwitchPreference
    private var conditionSwitch:Boolean = false
    private lateinit var reminderReceiver: ReminderReceiver

    companion object{
        private const val ALARM_TITLE = "alarm_title"
        private const val ALARM_MESSAGE = "alarm_message"
        private const val ID_REPEATING = 101
    }


    override fun onCreatePreferences(savedInstanceState: Bundle?, rootKey: String?) {
        addPreferencesFromResource(R.xml.preferences)
        init()
        reminderReceiver = ReminderReceiver()

    }

    private fun init() {
        switchPreference = findPreference<SwitchPreference>("switch") as SwitchPreference

        val sh = preferenceManager.sharedPreferences
        switchPreference.isChecked =  sh.getBoolean("switch",conditionSwitch)

    }
    private fun conditionSwitch() {
        if (switchPreference.isChecked){

            alarmSet()
        }else{

            cancelAlarm()
        }
    }
    private fun alarmSet() {
        val alarmManager = context?.getSystemService(Context.ALARM_SERVICE) as AlarmManager
        val intent = Intent(context,ReminderReceiver::class.java).apply {
            putExtra(ALARM_MESSAGE,"Check your Favorite Github User")
            putExtra(ALARM_TITLE,"Github Favorite List")
        }
        val pendingIntent = PendingIntent.getBroadcast(context, ID_REPEATING,intent,0)
        val timeAtMorning = Calendar.getInstance().apply {
            set(Calendar.HOUR_OF_DAY,8)
            set(Calendar.MINUTE,59)
            set(Calendar.SECOND,59)
        }

        alarmManager.setInexactRepeating(
            AlarmManager.RTC_WAKEUP,
            timeAtMorning.timeInMillis,
            AlarmManager.INTERVAL_DAY,
            pendingIntent
        )

    }
    private fun cancelAlarm(){
        val alarmManager = context?.getSystemService(Context.ALARM_SERVICE) as AlarmManager
        val intent = Intent(context,ReminderReceiver::class.java)
        val pendingIntent = PendingIntent.getBroadcast(context, ID_REPEATING,intent,0).also {
            it.cancel()
        }
        alarmManager.cancel(pendingIntent)
    }

    override fun onResume() {
        super.onResume()
        preferenceScreen.sharedPreferences.registerOnSharedPreferenceChangeListener(this)
        conditionSwitch()
    }

    override fun onPause() {
        super.onPause()
        preferenceScreen.sharedPreferences.unregisterOnSharedPreferenceChangeListener(this)
        conditionSwitch()

    }

    override fun onSharedPreferenceChanged(sharedPreferences: SharedPreferences, key: String) {
        if(key == "switch"){
            switchPreference.isChecked = sharedPreferences.getBoolean("switch",conditionSwitch)
            conditionSwitch()

        }
    }

}
