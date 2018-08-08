package com.andr0day.shellingdemo;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;

public class MyContentProvider extends ContentProvider {
    public MyContentProvider() {
    }

    @Override
    public int delete(Uri uri, String selection, String[] selectionArgs) {
        System.out.println("delete");
        return 0;
    }

    @Override
    public String getType(Uri uri) {
        System.out.println("getType");
        return "";
    }

    @Override
    public Uri insert(Uri uri, ContentValues values) {
        System.out.println("insert");
        return null;
    }

    @Override
    public boolean onCreate() {
        System.out.println("onCreate");
        return true;
    }

    @Override
    public Cursor query(Uri uri, String[] projection, String selection,
                        String[] selectionArgs, String sortOrder) {
        System.out.println("query");
        return null;
    }

    @Override
    public int update(Uri uri, ContentValues values, String selection,
                      String[] selectionArgs) {
        System.out.println("update");
        return 0;
    }
}
