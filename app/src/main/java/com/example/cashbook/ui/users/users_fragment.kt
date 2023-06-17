package com.example.cashbook.ui.users

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.os.Message
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RelativeLayout
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.cashbook.DataBase.DatabaseAction
import com.example.cashbook.MainActivity
import com.example.cashbook.R
import com.example.cashbook.databinding.UsersBinding
import com.example.cashbook.ui.detailed_accounts.all
import com.example.cashbook.ui.statistics.MonthView
import de.hdodenhof.circleimageview.CircleImageView

@Suppress("DEPRECATION")
class users_fragment : Fragment() {
    private var binding: UsersBinding? = null
    var month_array = arrayOf(0,31,28,31,30,31,30,31,31,30,31,30,31)
    var daybetw:Int = 0
    var numtran:Int = 0
    var allIn:Long = 0
    var allOut:Long = 0
    var property:Long = 0
    var days_count:TextView? = null
    var transaction_count:TextView? = null
    var property_count:TextView? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = UsersBinding.inflate(inflater, container, false)
        val root: View = binding!!.root
        val login:TextView = root.findViewById<TextView>(R.id.name)
        val login2: CircleImageView = root.findViewById<CircleImageView>(R.id.app_img)
        login.setOnClickListener {
            val intent = Intent(this@users_fragment.context, mylogin::class.java)
            startActivityForResult(intent,1)
        }
        login2.setOnClickListener {
            val intent = Intent(this@users_fragment.context, mylogin::class.java)
            startActivityForResult(intent,1)
        }
        if (MainActivity.username!="")
        {
            login.text = MainActivity.username

        }

        days_count = root.findViewById<TextView>(R.id.days)
        transaction_count = root.findViewById<TextView>(R.id.transactions)
        property_count = root.findViewById<TextView>(R.id.property)

        val settings_btn = root.findViewById<RelativeLayout>(R.id.settings)
        settings_btn.setOnClickListener {
            if (MainActivity.if_login){
                val intent = Intent(this@users_fragment.context, settings::class.java)
                startActivity(intent)
            }else{
                Toast.makeText(context, "请先登录！", Toast.LENGTH_LONG).show()
            }
        }
        val aboutus_btn = root.findViewById<RelativeLayout>(R.id.about_btn)
        aboutus_btn.setOnClickListener {
            val intent = Intent(this@users_fragment.context, about_us::class.java)
            startActivity(intent)
        }
        update()
        return root
    }

    override fun onResume() {
        super.onResume()
        update()
    }

    private fun update(){
        Thread{
            val new_year:Int = context?.let {
                DatabaseAction.getInstance(it)?.getAllIncomesDao
                    ?.getYearMax(MainActivity.username)
            }!!
            val new_month:Int = context?.let {
                DatabaseAction.getInstance(it)?.getAllIncomesDao
                    ?.getMonthMax(new_year, MainActivity.username)
            }!!
            val new_day:Int = context?.let {
                DatabaseAction.getInstance(it)?.getAllIncomesDao
                    ?.getDayMax(new_year,new_month, MainActivity.username)
            }!!

            val old_year:Int = context?.let {
                DatabaseAction.getInstance(it)?.getAllIncomesDao
                    ?.getYearMin(MainActivity.username)
            }!!
            val old_month:Int = context?.let {
                DatabaseAction.getInstance(it)?.getAllIncomesDao
                    ?.getMonthMin(old_year, MainActivity.username)
            }!!
            val old_day:Int = context?.let {
                DatabaseAction.getInstance(it)?.getAllIncomesDao
                    ?.getDayMin(old_year,old_month, MainActivity.username)
            }!!
            numtran = context?.let {
                DatabaseAction.getInstance(it)?.getAllIncomesDao
                    ?.getNumTran(MainActivity.username)
            }!!
            allIn = context?.let {
                DatabaseAction.getInstance(it)?.getAllIncomesDao
                    ?.getAllIn(MainActivity.username)
            }!!
            allOut = context?.let {
                DatabaseAction.getInstance(it)?.getAllIncomesDao
                    ?.getAllOut(MainActivity.username)
            }!!
            property = allIn-allOut
            if (numtran>0){
                daybetw = DayBetw(new_year,new_month,new_day,old_year,old_month,old_day)+1
            }else{
                daybetw = DayBetw(new_year,new_month,new_day,old_year,old_month,old_day)
            }
            val msg = Message()
            msg.what = MonthView.COMPLETED
            handler.sendMessage(msg)
        }.start()
    }

    val handler: Handler = object : Handler(Looper.getMainLooper()){
        override fun handleMessage(msg: Message) {
            if (msg.what == COMPLETED){
                days_count?.text = daybetw.toString()
                transaction_count?.text = numtran.toString()
                if (property>0){
                    property_count?.text = property.toString()
                }else{
                    property_count?.text = String.format("%.2f", property.toDouble() / 100)
                }
            }
        }
    }

    private fun IsLeap(year: Int):Boolean{
        return (year%4 == 0 && year%100 != 0 || year%400 == 0)
    }

    private fun CountDay(year: Int, month: Int, day: Int):Int{
        if(IsLeap(year)){
            month_array[2] = 29
        }
        else{
            month_array[2] = 28
        }
        var sum:Int = 0
        for (i in 1..month) {
            sum += if (i == month) {
                day
            } else {
                month_array[i]
            }
        }
        return sum
    }

    private fun DayBetw(new_year: Int, new_month: Int, new_day: Int, old_year: Int, old_month: Int, old_day :Int):Int{
        var sum:Int = 0
        if (new_year == old_year && new_month == old_month){
            sum = new_day - old_day
        }
        else if(new_year == old_year){
            sum = CountDay(new_year,new_month,new_day) - CountDay(old_year,old_month,old_day)
        }
        else{
            if (IsLeap(old_year)){
                sum+=366-CountDay(old_year,old_month,old_day)
            }
            else{
                sum+=365-CountDay(old_year,old_month,old_day)
            }
            for (i in old_year+1 until new_year){
                val year:Int = if (IsLeap(i)){
                    366
                }else{
                    365
                }
                sum+=year
            }
            sum+=CountDay(new_year,new_month,new_day)
        }
        return sum
    }

    companion object{
        const val COMPLETED = -1
    }
}