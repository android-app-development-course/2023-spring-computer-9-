package com.example.cashbook.ui.users

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import com.example.cashbook.DataBase.Mysql

class users_dao(context:Context) {
    val mysql = Mysql(context,"Userinfo",null,1)
    lateinit var db:SQLiteDatabase
    fun openDatebase() {
        db = mysql.writableDatabase
    }
    fun insertUser(username: String, userpassword: String){
        val values = ContentValues().apply {
            put("usname",username)
            put("uspwd",userpassword)
        }
        db.insert("logins",null,values)
    }
    fun queryUser(username: String, userpassword: String):Boolean{
        val data: Array<String> = arrayOf("usname", "uspwd")
        val data2: Array<String> = arrayOf(username, userpassword)
        val cursor:Cursor = db.query("logins", data, " usname=? and uspwd=?", data2, null, null, null)
        val flag: Int = cursor.count
        cursor.close()
        return flag>0
    }
    fun queryUserbyID(username: String):Boolean{
        val data: Array<String> = arrayOf("usname")
        val data2: Array<String> = arrayOf(username)
        val cursor:Cursor = db.query("logins", data, " usname=?", data2, null, null, null)
        val flag: Int = cursor.count
        cursor.close()
        return flag<=0
    }
    fun deleteUser(username: String){
        db.delete("logins","usname=?", arrayOf(username))
    }
    fun updateUser(username: String,userpassword: String){
        val values = ContentValues().apply {
            put("uspwd",userpassword)
        }
        db.update("logins",values,"usname = ?", arrayOf(username))
    }
}