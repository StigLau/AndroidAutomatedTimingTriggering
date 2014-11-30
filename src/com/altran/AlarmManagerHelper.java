package com.altran;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class AlarmManagerHelper extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        Log.i("Hello", "AlarmManager onReceive");
        setAlarms(context);
    }


    public static void setAlarms(Context context) {
        cancelAlarms(context);

        PendingIntent pIntent = createPendingIntent(context);
        setAlarm(context, pIntent);
    }

    //@SuppressLint("NewApi")
    private static void setAlarm(Context context, PendingIntent pIntent) {
        AlarmManager alarmManager = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.KITKAT) {
            alarmManager.setInexactRepeating(AlarmManager.ELAPSED_REALTIME, 5000, 5000, pIntent);
        } else {
            alarmManager.set(AlarmManager.ELAPSED_REALTIME, 5000, pIntent);
        }
    }

    /**
     * TODO Trenger vi denne?
     */
    public static void cancelAlarms(Context context) {

        PendingIntent pIntent = createPendingIntent(context);

        AlarmManager alarmManager = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);
        alarmManager.cancel(pIntent);

    }

    private static PendingIntent createPendingIntent(Context context) {
        Intent intent = new Intent(context, AlarmService.class);
        intent.putExtra("time", 1000);

        int requestCode = 1234;
        return PendingIntent.getService(context, requestCode, intent, PendingIntent.FLAG_UPDATE_CURRENT);
    }


}