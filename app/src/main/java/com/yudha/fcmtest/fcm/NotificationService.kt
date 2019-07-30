package com.yudha.fcmtest.fcm

import android.support.v4.app.NotificationCompat
import android.support.v4.app.NotificationManagerCompat
import android.util.Log
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage
import com.yudha.fcmtest.R


class NotificationService : FirebaseMessagingService() {
    var TAG = "FIREBASE MESSAGING"

    override fun onNewToken(p0: String?) {
        super.onNewToken(p0)
    }

    override fun onMessageReceived(remoteMessage: RemoteMessage?) {
        super.onMessageReceived(remoteMessage)

        Log.d(TAG, "From: " + remoteMessage?.from)

        if (!remoteMessage?.data.isNullOrEmpty()) {
            Log.d(TAG, "Message data payload: " + remoteMessage!!.data)



        }

        // Check if message contains a notification payload.
        if (remoteMessage?.notification != null) {

            Log.d(TAG, "Message Notification Body: " + remoteMessage.notification?.body)

            val mBuilder = NotificationCompat.Builder(applicationContext, "test_notif")
                .setSmallIcon(R.drawable.ic_launcher_foreground)
                .setContentTitle("Yey its work")
                .setContentText("Notifikasi keren cool magic")
                .setPriority(NotificationCompat.PRIORITY_DEFAULT)

            val mNotifManager = NotificationManagerCompat.from(applicationContext)
            mNotifManager.notify(1, mBuilder.build())
        }

    }
}
