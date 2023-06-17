package com.example.cashbook.ui.detailed_accounts

import android.app.DatePickerDialog
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.os.Message
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import android.widget.AdapterView.OnItemClickListener
import androidx.fragment.app.Fragment
import com.example.cashbook.Card
import com.example.cashbook.CardsAdapter
import com.example.cashbook.DataBase.DatabaseAction
import com.example.cashbook.DataBase.MyDatabase
import com.example.cashbook.MainActivity
import com.example.cashbook.R
import java.util.*
import kotlin.collections.ArrayList

class add_expenditure:Fragment() {
    private val outTypeList:ArrayList<Card> = arrayListOf()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.add_expenditure, container, false)
        val gridView:GridView = root.findViewById(R.id.exTypeList)
        initcards()
        adapter = this.context?.let { CardsAdapter(it, outTypeList, 0) }
        gridView.adapter = adapter
        gridView.onItemClickListener =
            OnItemClickListener { parent: AdapterView<*>?, view: View?, position: Int, id: Long ->
                add_accounts.inOut = true
                add_accounts.type = outTypeList[position].getName().toString()
                adapter!!.setSelPos(position)
                if (add_income.adapter != null) {
                    add_income.adapter!!.setSelPos(-1)
                    add_income.adapter!!.notifyDataSetChanged()
                    val handler = Handler()
                    handler.postDelayed(
                        { add_income.adapter!!.notifyDataSetChanged() },
                        500
                    )
                    Log.d("TAG", "update income from expenditure")
                }
                adapter!!.notifyDataSetChanged()
            }

        val chooseDate = root.findViewById<TextView>(R.id.chooseDate)
        val moneyTxt = root.findViewById<EditText>(R.id.money)
        val remarkTxt = root.findViewById<EditText>(R.id.remarkText)
        val addBt = root.findViewById<Button>(R.id.addBt)

        if (chooseDate != null) {
            chooseDate.setOnClickListener {

                //获取实例，包含当前年月日
                val calendar = Calendar.getInstance()
                val dialog1 = context?.let { it1 ->
                    DatePickerDialog(
                        it1,
                        { view1: DatePicker?, year: Int, month: Int, dayOfMonth: Int ->
                            chooseDate.text = String.format(
                                "%d年%d月%d日",
                                year,
                                month + 1,
                                dayOfMonth
                            )
                            //                Toast.makeText(getContext(), year + "-" + (month + 1) + "-" + dayOfMonth, Toast.LENGTH_SHORT).show();
                            add_accounts.date[0] = year
                            add_accounts.date[1] = month + 1
                            add_accounts.date[2] = dayOfMonth
                        },
                        calendar[Calendar.YEAR],
                        calendar[Calendar.MONTH],
                        calendar[Calendar.DAY_OF_MONTH]
                    )
                }
                if (dialog1 != null) {
                    dialog1.show()
                }
            }
            moneyTxt!!.addTextChangedListener(object : TextWatcher {
                override fun beforeTextChanged(
                    s: CharSequence,
                    start: Int,
                    count: Int,
                    after: Int
                ) {
                }

                override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
                    //如果第一个数字为0，第二个不为点，就不允许输入
                    var s = s
                    if (s.toString().startsWith("0") && s.toString()
                            .trim { it <= ' ' }.length > 1
                    ) {
                        if (s.toString()[1] != '.') {
                            moneyTxt.setText(s.subSequence(0, 1))
                            moneyTxt.setSelection(1)
                            return
                        }
                    }
                    //如果第一为点，直接显示0.
                    if (s.toString().startsWith(".")) {
                        moneyTxt.setText("0.")
                        moneyTxt.setSelection(2)
                        return
                    }
                    //限制输入小数位数(2位)
                    if (s.toString().contains(".")) {
                        if (s.length - 1 - s.toString().indexOf(".") > 2) {
                            s = s.toString().subSequence(0, s.toString().indexOf(".") + 2 + 1)
                            moneyTxt.setText(s)
                            moneyTxt.setSelection(s.length)
                        }
                        if (s.toString().indexOf(".") > 8) {
                            s = s.toString()
                                .substring(0, s.toString().indexOf(".") - 1) + s.toString()
                                .substring(s.toString().indexOf("."), s.length)
                            moneyTxt.setText(s)
                            moneyTxt.setSelection(s.length)
                        }
                    }
                    //限制整数部分长度
                    if (!s.toString().contains(".")) {
                        if (s.length > 8) {
                            moneyTxt.setText(s.subSequence(0, s.length - 1))
                            moneyTxt.setSelection(s.length - 1)
                        }
                    }
                }

                override fun afterTextChanged(s: Editable) {}
            })
            if (addBt != null) {
                addBt.setOnClickListener(View.OnClickListener { v: View? ->
                    if (!add_accounts.inOut){
                        Toast.makeText(context, "请先选择类型！", Toast.LENGTH_SHORT).show()
                    }else if(moneyTxt!!.text.toString() == ""){
                        Toast.makeText(context, "收入不能为零！", Toast.LENGTH_SHORT).show()
                    }else{
                        if (chooseDate.text.toString() == "今天") {
                            add_accounts.date[0] = Calendar.getInstance()[Calendar.YEAR]
                            add_accounts.date[1] = Calendar.getInstance()[Calendar.MONTH] + 1
                            add_accounts.date[2] = Calendar.getInstance()[Calendar.DAY_OF_MONTH]
                        }
                        add_accounts.remark = remarkTxt!!.text.toString()
                        val mn: Double =
                            if (moneyTxt!!.text.toString() == "") 0.0
                            else moneyTxt!!.text.toString()
                                .toDouble()
                        add_accounts.moneyAcc = (mn * 100).toLong()
                        Log.d(
                            "TAG",
                            "onClick: " + mn + "  " + add_accounts.moneyAcc
                        )
                        Thread {
                            context?.let {
                                var data = MyDatabase(
                                    add_accounts.moneyAcc,
                                    add_accounts.date[0],
                                    add_accounts.date[1],
                                    add_accounts.date[2],
                                    add_accounts.type,
                                    add_accounts.remark,
                                    add_accounts.inOut,
                                    add_accounts.username
                                )
                                DatabaseAction.getInstance(it)?.getAllIncomesDao?.insert(
                                    data
                                )
                            }
                            all.allList =
                                context?.let { DatabaseAction.getInstance(it)?.getAllIncomesDao?.getAllAccounts(
                                    MainActivity.username) } as List<MyDatabase>
                            val msg = Message()
                            msg.what = all.COMPLETED
                            all.handler.sendMessage(msg)
                            val msg2 = Message()
                            msg2.what = all.COMPLETED
                            if (add_accounts.inOut) {
                                expenditure.expenditureList =
                                    DatabaseAction.getInstance(context!!)?.getAllIncomesDao
                                        ?.getAllExpense(MainActivity.username) as List<MyDatabase>
                                expenditure.handler.sendMessage(msg2)
                            } else {
                                income.incomeList =
                                    DatabaseAction.getInstance(context!!)?.getAllIncomesDao
                                        ?.getAllIncomes(MainActivity.username) as List<MyDatabase>
                                income.handler.sendMessage(msg2)
                            }
                            Looper.prepare()
                            Toast.makeText(context, "添加成功", Toast.LENGTH_SHORT).show()
                            Looper.loop()
                        }.start()
                        MainActivity.if_Set_Database = true
                        val intent = Intent(activity, MainActivity::class.java)
                        startActivity(intent)
                    }
                })
            }
        }
        
        return root
    }

    companion object {
        /**
         * 单例，返回给定节编号的此片段的新实例。
         */
        @JvmStatic
        fun newInstance(sectionNumber: Int): add_expenditure {
            return add_expenditure().apply {
            }
        }

        var adapter:CardsAdapter? = null
    }

    private fun initcards(){
        outTypeList.add(Card("餐饮",R.drawable.ic_expenditure_food))
        outTypeList.add(Card("购物",R.drawable.ic_expenditure_shopping))
        outTypeList.add(Card("日用",R.drawable.ic_expenditure_daily))
        outTypeList.add(Card("旅行",R.drawable.ic_expenditure_travel))
        outTypeList.add(Card("水果",R.drawable.ic_expenditure_fruit))
        outTypeList.add(Card("礼物",R.drawable.ic_expenditure_gift))
        outTypeList.add(Card("就医",R.drawable.ic_expenditure_doctor))
        outTypeList.add(Card("其他",R.drawable.ic_expenditure_other))
    }

}