package com.example.cashbook.ui.users

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.database.sqlite.SQLiteDatabase
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.os.Message
import android.provider.ContactsContract.Data
import android.view.View
import android.widget.Button
import android.widget.RelativeLayout
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.DialogFragment
import com.example.cashbook.DataBase.DatabaseAction
import com.example.cashbook.DataBase.Mysql
import com.example.cashbook.MainActivity
import com.example.cashbook.R
import com.example.cashbook.ui.statistics.MonthView

class settings:AppCompatActivity() {

    private var mAlertDialog: AlertDialog? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.settings)
        val clear_button = findViewById<RelativeLayout>(R.id.clear_all)
        val cancel_button = findViewById<RelativeLayout>(R.id.cancel_user)
        val switch_button = findViewById<RelativeLayout>(R.id.switch_button)
        val logout_button = findViewById<RelativeLayout>(R.id.logout_button)
        val usersDao = users_dao(this)
        usersDao.openDatebase()
        clear_button.setOnClickListener {
            showDialogYN("确认要清空帐单吗？","clear",usersDao)
        }
        cancel_button.setOnClickListener {
            showDialogYN("确认要注销账号吗？","cancel",usersDao)
        }
        switch_button.setOnClickListener {
            val intent = Intent(this@settings, change_password::class.java)
            startActivity(intent)
        }
        logout_button.setOnClickListener {
            MainActivity.username = ""
            MainActivity.if_login = false
            val intent = Intent(this@settings, MainActivity::class.java)
            startActivity(intent)
            Toast.makeText(this@settings, "已退出登录！", Toast.LENGTH_LONG).show()
        }
    }


    fun Context.showDialogYN(hintText: String,selector: String,usersDao: users_dao) {
        if (mAlertDialog != null&& this == mAlertDialog!!.context && mAlertDialog!!.isShowing ) {
            //表示在同一个activity，已经显示了，就不再显示
            return
        }
        if (mAlertDialog == null || this != mAlertDialog!!.context) {
            mAlertDialog = AlertDialog.Builder(this, R.style.TransparentDialog).create()//背景透明的dialog
        }
        val view1 = View.inflate(this, R.layout.alterdialog_yes_no, null)//有ready

        mAlertDialog!!.setView(view1)
        mAlertDialog!!.show()

        val tv_message = view1.findViewById<TextView>(R.id.tv_message)
        val btn_confirm = view1.findViewById<Button>(R.id.btn_confirm)
        val btn_cancel = view1.findViewById<Button>(R.id.btn_cancel)

        tv_message.text = hintText

        btn_confirm.setOnClickListener {
            //按了yes按钮
            mAlertDialog!!.dismiss()
            if (selector == "clear")
            {
                Thread{
                    DatabaseAction.getInstance(this)?.getAllIncomesDao?.DeleteAll(MainActivity.username)
                    val msg = Message()
                    msg.what = MonthView.COMPLETED
                    handler.sendMessage(msg)
                }.start()
            }
            else if (selector == "cancel"){
                usersDao.deleteUser(MainActivity.username)
                Thread{
                    DatabaseAction.getInstance(this)?.getAllIncomesDao?.DeleteAll(MainActivity.username)
                    val msg = Message()
                    msg.what = MonthView.COMPLETED
                    handler.sendMessage(msg)
                }.start()
                MainActivity.username = ""
                val intent = Intent(this@settings,MainActivity::class.java)
                startActivity(intent)
                Toast.makeText(this@settings, "注销成功！", Toast.LENGTH_LONG).show()
            }
        }
        btn_cancel.setOnClickListener {
            //按了no按钮
            mAlertDialog!!.dismiss()
        }
    }
    val handler: Handler = object : Handler(Looper.getMainLooper()){
        override fun handleMessage(msg: Message) {
            if (msg.what == users_fragment.COMPLETED){
                Toast.makeText(this@settings, "清空成功！", Toast.LENGTH_LONG).show();
            }
        }
    }
}