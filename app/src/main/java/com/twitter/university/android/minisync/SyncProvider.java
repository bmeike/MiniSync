/*
 * Copyright (c) 2014 Twitter Inc.
 */
package com.twitter.university.android.minisync;

import android.content.ContentProvider;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.util.Log;


public class SyncProvider extends ContentProvider {
    public static final String AUTHORITY = "com.twitter.university.android.minisync";
    public static final Uri URI
        = new Uri.Builder().scheme(ContentResolver.SCHEME_CONTENT).authority(AUTHORITY).build();

    @Override
    public boolean onCreate() { return true; }

    @Override
    public String getType(Uri uri) {
        Log.d("CP", "type: " + uri);
        return null;
    }

    @Override
    public Cursor query(Uri uri, String[] proj, String sel, String[] selArgs, String sort) {
        Log.d("CP", "query: " + uri);
        return null;
    }

    @Override
    public Uri insert(Uri uri, ContentValues contentValues) {
        Log.d("CP", "insert: " + uri);
        return uri;
    }

    @Override
    public int delete(Uri uri, String s, String[] strings) {
        Log.d("CP", "update: " + uri);
        return 0;
    }

    @Override
    public int update(Uri uri, ContentValues contentValues, String s, String[] strings){
        Log.d("CP", "delete: " + uri);
        return 0;
    }
}
