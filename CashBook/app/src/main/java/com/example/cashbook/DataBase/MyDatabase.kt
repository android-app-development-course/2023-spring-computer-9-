package com.example.cashbook.DataBase

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "MyDatabase")
data class MyDatabase     //false为收入，true为支出
    (
    var money: Long,
    var year: Int,
    var month: Int,
    var day: Int,
    var type: String,
    var remark: String, //false为收入，true为支出
    var inOut: Boolean,
    var username: String
) {
    @PrimaryKey(autoGenerate = true) //主键是否自动增长，默认为false
    var id = 0

    fun setMoney(money: Int) {
        this.money = money.toLong()
    }
}