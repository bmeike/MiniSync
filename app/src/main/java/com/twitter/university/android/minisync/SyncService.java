/*
 * Copyright (c) 2014 Twitter Inc.
 */
package com.twitter.university.android.minisync;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;


public class SyncService extends Service {
    private static final String ACTION_BIND_SYNC = "android.content.SyncAdapter";

    private static volatile SyncAdapter syncAdapter;

    private static final Object syncAdapterLock = new Object();

    @Override
    public void onCreate() {
        super.onCreate();
        synchronized (syncAdapterLock) {
            if (syncAdapter == null) {
                syncAdapter = new SyncAdapter(getApplicationContext(), true);
            }
        }
    }

    @Override
    public IBinder onBind(Intent intent) {
        Log.d("SVC", "bind: " + intent);
        if (ACTION_BIND_SYNC.equals(intent.getAction())) {
            return syncAdapter.getSyncAdapterBinder();
        }
        return null;
    }
}
