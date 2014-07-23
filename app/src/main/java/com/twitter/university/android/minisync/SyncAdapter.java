/*
 * Copyright (c) 2014 Twitter Inc.
 */
package com.twitter.university.android.minisync;

import android.accounts.Account;
import android.content.AbstractThreadedSyncAdapter;
import android.content.ContentProviderClient;
import android.content.Context;
import android.content.SyncResult;
import android.os.Bundle;
import android.util.Log;


public class SyncAdapter extends AbstractThreadedSyncAdapter {

    public SyncAdapter(Context context, boolean autoInitialize) {
        super(context, autoInitialize);
    }

    @Override
    public void onPerformSync(
        Account account,
        Bundle bundle,
        String s,
        ContentProviderClient contentProviderClient,
        SyncResult syncResult)
    {
        Log.d("SYNC", "sync: " + account);
    }
}
