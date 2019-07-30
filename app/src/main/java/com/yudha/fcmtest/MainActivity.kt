package com.yudha.fcmtest

import android.app.NotificationChannel
import android.app.NotificationManager
import android.os.Build
import android.os.Bundle
import android.support.annotation.RequiresApi
import android.support.v4.app.NotificationCompat
import android.support.v4.app.NotificationManagerCompat
import android.support.v7.app.AppCompatActivity
import com.google.firebase.iid.FirebaseInstanceId
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    val CHANNEL_ID = "test_notif"
    val CHANNEL_TITLE = "Test Notif"
    val CHANNEL_DESC = "Test notif app"

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnNotif.setOnClickListener {
            displayNotification()
        }

        FirebaseInstanceId.getInstance().instanceId.addOnCompleteListener{
            if (it.isSuccessful){
                txtRegToken.text = it.result?.token
            }
            else{
                txtRegToken.text = it.exception?.message
            }
        }
    }

    private fun displayNotification(){
        val mBuilder = NotificationCompat.Builder(this, CHANNEL_ID)
            .setSmallIcon(R.drawable.notification_template_icon_bg)
            .setContentTitle("Yey its work")
            .setContentText("Notifikasi keren cool magic")
            .setPriority(NotificationCompat.PRIORITY_DEFAULT)

        val mNotifManager = NotificationManagerCompat.from(this)
        mNotifManager.notify(1, mBuilder.build())
    }
}
