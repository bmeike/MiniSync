/*
 * Copyright (c) 2014 Twitter Inc.
 */
package com.twitter.university.android.minisync;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;


public class SyncService extends Service {
    private static final String TAG = "SVC";

    private static final String ACTION_BIND_SYNC = "android.content.SyncAdapter";


    @Override
    public IBinder onBind(Intent intent) {
        Log.d(TAG, "bind: " + intent);

        if (ACTION_BIND_SYNC.equals(intent.getAction())) {
            return new SyncAdapter(getApplicationContext(), true).getSyncAdapterBinder();
        }

        return null;
    }
}
