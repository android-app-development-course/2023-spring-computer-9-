package com.example.cashbook.ui.users

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.cashbook.MainActivity
import com.example.cashbook.R

class change_password:AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.change_password)
        val password = findViewById<EditText>(R.id.Password)
        val password2 = findViewById<EditText>(R.id.Password2)
        val submit = findViewById<Button>(R.id.submit)
        val usersDao = users_dao(this)
        usersDao.openDatebase()

        submit.setOnClickListener {
            val password_string = password.text.toString()
            val password2_string = password2.text.toString()
            if (password_string == password2_string){
                usersDao.updateUser(MainActivity.username,password_string)
                val intent = Intent()
                intent.setClass(this@change_password, MainActivity::class.java)
                startActivity(intent)
                Toast.makeText(this@change_password, "更改成功！", Toast.LENGTH_LONG).show()
            }else{
                Toast.makeText(this@change_password, "密码不一致！", Toast.LENGTH_LONG).show()
            }
        }
    }
}