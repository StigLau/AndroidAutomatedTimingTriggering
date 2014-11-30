package com.altran;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

public class AlarmService extends Service {

    @Override
    public IBinder onBind(Intent intent) {
        Log.i("Alarmservice", "Bound");
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.i("AlarmService", "onStartCommand");

        return super.onStartCommand(intent, flags, startId);

    }
}