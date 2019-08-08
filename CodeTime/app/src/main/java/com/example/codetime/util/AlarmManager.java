package com.example.codetime.util;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;

import java.util.Calendar;

public class AlarmManager {
    private static Calendar calendar;

    public AlarmManager(){
        calendar = Calendar.getInstance();
    }
    public static void setAlarm(String hour, String minute, String month, String day, Intent intent, PendingIntent pendingIntent){
        calendar.set(Calendar.HOUR_OF_DAY,Integer.parseInt(hour));
        calendar.set(Calendar.MINUTE,Integer.parseInt(minute));
        calendar.set(Calendar.DATE,Integer.parseInt(day));
        calendar.set(Calendar.MONTH, Integer.parseInt(month));

    }
}