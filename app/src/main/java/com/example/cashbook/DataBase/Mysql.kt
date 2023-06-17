package com.example.cashbook.DataBase

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

class Mysql(context: Context, name: String, factory: SQLiteDatabase.CursorFactory?, version: Int):
    SQLiteOpenHelper(context,name,factory,version) {

    override fun onCreate(db: SQLiteDatabase?) {
        val sql = "create table logins(id integer primary key autoincrement,usname text,uspwd text)"
        db!!.execSQL(sql)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        TODO("Not yet implemented")
    }
}