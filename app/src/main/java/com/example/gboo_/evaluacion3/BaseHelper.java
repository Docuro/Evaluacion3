package com.example.gboo_.evaluacion3;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Gboo_ on 06-12-2017.
 */

public class BaseHelper extends SQLiteOpenHelper {
    public BaseHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table persona(id integer primary key,name text, pass text)");
        db.execSQL("insert into persona values('admin','admin')");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("create table persona(id integer primary key,name text, pass text)");
        db.execSQL("insert into persona values('admin','admin')");
    }
}

