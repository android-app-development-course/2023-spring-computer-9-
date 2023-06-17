package com.example.cashbook.ui.users

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.cashbook.R

class myregister:AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.myregister)
        val usename: EditText = findViewById(R.id.Username)
        val usepwd: EditText = findViewById(R.id.Password)
        val usepwd2: EditText = findViewById(R.id.Password2)
        val submit: Button = findViewById(R.id.register)
        val usersDao = users_dao(this)
        usersDao.openDatebase()

        submit.setOnClickListener {
            var flag: Boolean = true
            val username: String = usename.text.toString()
            val password: String = usepwd.text.toString()
            val password2: String = usepwd2.text.toString()
            if (username.equals("") || password.equals("") || password2.equals("")) {
                Toast.makeText(this@myregister, "用户名或密码不能为空!！", Toast.LENGTH_LONG).show();
            } else {
                flag = usersDao.queryUserbyID(username)
                if (flag) {
                    if (password == password2) {
                        usersDao.insertUser(username, password)

                        val intent = Intent()
                        intent.setClass(this@myregister, mylogin::class.java)
                        startActivity(intent)
                        Toast.makeText(this@myregister, "注册成功！", Toast.LENGTH_LONG).show()
                    } else {
                        Toast.makeText(this@myregister, "密码不一致！", Toast.LENGTH_LONG).show()
                    }
                } else {
                    Toast.makeText(this@myregister, "用户已存在！", Toast.LENGTH_LONG).show()
                }
            }
        }
    }
}