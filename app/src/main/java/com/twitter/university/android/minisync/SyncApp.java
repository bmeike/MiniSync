/*
 * Copyright (c) 2014 Twitter Inc.
 */
package com.twitter.university.android.minisync;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.app.Application;
import android.content.ContentResolver;
import android.os.Bundle;
import android.util.Log;


public class SyncApp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d("APP", "create");

        String acctType = getString(R.string.account_type);
        Account[] accounts = AccountManager.get(this).getAccountsByType(acctType);
        if (0 >= accounts.length) {
            addAccount("MiniSync", acctType);
        }
    }

    private void addAccount(String name, String acctType) {
        Account account = new Account(name, acctType);
        AccountManager.get(this).addAccountExplicitly(account, null, null);
        ContentResolver.setIsSyncable(account, SyncProvider.AUTHORITY, 1);
        ContentResolver.setSyncAutomatically(account, SyncProvider.AUTHORITY, true);
        ContentResolver.addPeriodicSync(account, SyncProvider.AUTHORITY, new Bundle(), 15 * 60);
        Log.d("APP", "account: " + account);
    }
}
