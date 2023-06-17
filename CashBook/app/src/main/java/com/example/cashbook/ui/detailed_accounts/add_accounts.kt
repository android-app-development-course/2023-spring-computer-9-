package com.example.cashbook.ui.detailed_accounts

import android.app.DatePickerDialog
import android.content.Context
import android.os.Bundle
import android.os.Looper
import android.os.Message
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.viewpager.widget.ViewPager
import com.example.cashbook.DataBase.DatabaseAction
import com.example.cashbook.DataBase.MyDatabase
import com.example.cashbook.MainActivity
import com.example.cashbook.R
import com.google.android.material.tabs.TabLayout
import java.security.AccessController.getContext
import java.util.*

class SectionsPagerAdapter(private val context: Context, fm: FragmentManager)
    : FragmentPagerAdapter(fm) {
    //顶部tablayout的字符
    private val TAB_TITLES = arrayOf(
        "支出",
        "收入"
    )

    override fun getItem(position: Int): Fragment {
        // 顶部有多少个tab，就会运行多少次（初次会加载第一第二，第三第四要点第三个tab才会运行）
        /*******新建Fragment******/
        when (position) {
            0 -> {
                return add_expenditure.newInstance(position + 1)
            }
            else -> {
                return add_income.newInstance(position + 1)
            }
        }
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return TAB_TITLES[position]
    }

    override fun getCount(): Int {
        // 顶部显示多少个页，不要超过TAB_TITLES的总数.
        return 2
    }
}


class add_accounts:AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.add_accounts)
        val sectionsPagerAdapter = SectionsPagerAdapter(this, supportFragmentManager)
        val viewPager: ViewPager = findViewById(R.id.viewpager_add)
        viewPager.adapter = sectionsPagerAdapter
        val tabs: TabLayout = findViewById(R.id.tabs_add)
        tabs.setupWithViewPager(viewPager)
    }

    companion object {
        var type: String = "餐饮"
        var inOut: Boolean = true
        var date = intArrayOf(0, 0, 0)
        var remark = ""
        var moneyAcc: Long = 0
        var username: String = MainActivity.username
    }


}

