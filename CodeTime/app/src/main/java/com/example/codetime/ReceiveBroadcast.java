package com.example.codetime;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;

public class ReceiveBroadcast extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(context)
                .setSmallIcon(R.drawable.ic_notifications_active_black_24dp)
                .setContentTitle("Contest Time")
                .setContentText("");

        NotificationManagerCompat notiMng = NotificationManagerCompat.from(context);
        notiMng.notify(1,mBuilder.build());
    }
}
