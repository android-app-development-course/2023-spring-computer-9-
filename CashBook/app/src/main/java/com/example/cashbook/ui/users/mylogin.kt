package com.example.cashbook.ui.users

import android.content.Intent
import android.os.Bundle
import android.view.KeyEvent
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.cashbook.MainActivity
import com.example.cashbook.R

class mylogin:AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.mylogin)
        val name: EditText = findViewById(R.id.Username)
        val pwd: EditText = findViewById(R.id.Password)
        val btn_login: Button = findViewById(R.id.login)
        val btn_reg: TextView = findViewById(R.id.go_register)
        val usersDao = users_dao(this)
        usersDao.openDatebase()

        btn_login.setOnClickListener {
            val username: String = name.text.toString()
            val password: String = pwd.text.toString()
            val flag:Boolean = usersDao.queryUser(username,password)
            if (flag) {
                val intent = Intent()
                intent.setClass(this@mylogin, MainActivity::class.java)
                MainActivity.username = username
                MainActivity.if_login = true
                startActivity(intent)
                Toast.makeText(this@mylogin, "登陆成功！", Toast.LENGTH_LONG).show();
            } else {
                Toast.makeText(this@mylogin, "用户名或密码错误！", Toast.LENGTH_LONG).show();
            }
        }

        btn_reg.setOnClickListener {
            val intent = Intent()
            intent.setClass(this@mylogin, myregister::class.java)
            startActivity(intent)
        }
    }

}