package com.example.submissionone.broadcast

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.media.RingtoneManager
import android.os.Build
import androidx.core.app.NotificationCompat
import androidx.core.content.ContextCompat
import com.example.submissionone.R
import com.example.submissionone.view.SplashActivity

class ReminderReceiver : BroadcastReceiver() {
    companion object{
        private const val ALARM_TITLE = "alarm_title"
        private const val ALARM_MESSAGE = "alarm_message"
        private const val ID_REPEATING = 101
    }
    override fun onReceive(context: Context, intent: Intent) {
        val message = intent.getStringExtra(ALARM_MESSAGE)
        val notifIntent = Intent(context,SplashActivity::class.java).apply {
            flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        }
        val pendingIntent = PendingIntent.getActivity(context,0,notifIntent,0)
        val title = intent.getStringExtra(ALARM_TITLE)
        val notifId =ID_REPEATING
        context.let{
            showAlarmNotification(
                context,
                title?: "Tittle",
                message ?: "Message",
                notifId,
                pendingIntent
            )
        }
    }
    private fun showAlarmNotification(context: Context, title: String, message: String, notifId: Int,intent:PendingIntent) {
        val CHANNEL_ID = "Channel_1"
        val CHANNEL_NAME = "AlarmManager channel"
        val notificationManagerCompat = context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        val alarmSound = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION)
        val builder = NotificationCompat.Builder(context, CHANNEL_ID)
            .setSmallIcon(R.drawable.ic_baseline_notifications_active_24)
            .setContentTitle(title)
            .setContentText(message)
            .setColor(ContextCompat.getColor(context, android.R.color.transparent))
            .setVibrate(longArrayOf(1000, 1000, 1000, 1000, 1000))
            .setSound(alarmSound)
            .setContentIntent(intent)

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val channel = NotificationChannel(CHANNEL_ID,
                CHANNEL_NAME,
                NotificationManager.IMPORTANCE_DEFAULT)
            channel.enableVibration(true)
            channel.vibrationPattern = longArrayOf(1000, 1000, 1000, 1000, 1000)
            builder.setChannelId(CHANNEL_ID)
            notificationManagerCompat.createNotificationChannel(channel)
        }
        val notification = builder.build()
        notificationManagerCompat.notify(notifId, notification)
    }
}