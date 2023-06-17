package com.example.cashbook.ui.detailed_accounts

import android.app.Dialog
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.os.Message
import android.view.*
import android.widget.PopupMenu
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.cashbook.DataBase.DatabaseAction
import com.example.cashbook.AccountItemAdapter
import com.example.cashbook.DataBase.MyDatabase
import com.example.cashbook.MainActivity
import com.example.cashbook.R
import java.util.*

class expenditure:Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        refreshList()
        if (arguments != null) {
            // TODO: Rename and change types of parameters
            val mParam1 = arguments!!.getString(ARG_PARAM1)
            val mParam2 = arguments!!.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val root: View = inflater.inflate(R.layout.expenditure, container, false)
        val recyclerView = root.findViewById<RecyclerView>(R.id.expenditureList)
        val layoutManager = LinearLayoutManager(this.context)
        recyclerView.layoutManager = layoutManager
        recyclerView.adapter = adapter
        if (MainActivity.if_Set_Database){
            refreshList()
        }
        adapter?.setOnItemClickListener(object :
            AccountItemAdapter.OnItemClickListener {
            override fun onClick(position: Int, v: View?) {
                val dialog = Dialog(context!!)
                //去掉标题线
                dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
                val view: View = LayoutInflater.from(context).inflate(R.layout.detail, null, false)
                val mdb: MyDatabase = expenditureList[position]
                var txt = view.findViewById<TextView>(R.id.detailInOut)
                txt.text = if (mdb.inOut) "支出" else "收入"
                txt = view.findViewById<TextView>(R.id.detailType)
                txt.text = "：" + mdb.type
                txt = view.findViewById<TextView>(R.id.detailDate)
                txt.text = java.lang.String.format(
                    Locale.CHINA,
                    "%d年%d月%d日",
                    mdb.year,
                    mdb.month,
                    mdb.day
                )
                txt = view.findViewById<TextView>(R.id.detailMoney)
                txt.text = String.format("%.2f", mdb.money.toDouble() / 100)
                txt = view.findViewById<TextView>(R.id.detailRemark)
                txt.setText(mdb.remark)
                dialog.setContentView(view)
                //背景透明
                dialog.window!!.setBackgroundDrawableResource(android.R.color.transparent)
                dialog.show()
            }

            override fun onLongClick(position: Int, v: View?) {
                editMenu(position, v!!)
            }
        })
        return root
    }

    override fun onResume() {
        super.onResume()
        refreshList()
    }

    private fun editMenu(position: Int, v: View) {
        val popupMenu = PopupMenu(context, v)
        popupMenu.menuInflater.inflate(R.menu.long_click_menu, popupMenu.menu)
        popupMenu.setOnMenuItemClickListener { item: MenuItem ->
            if (item.itemId == R.id.delete) {
                Thread {
                    context?.let {
                        DatabaseAction.getInstance(it)?.getAllIncomesDao
                            ?.delete(expenditureList[position])
                    }
                    all.allList =
                        context?.let { DatabaseAction.getInstance(it)?.getAllIncomesDao?.getAllAccounts(MainActivity.username) } as List<MyDatabase>
                    val msg = Message()
                    msg.what = all.COMPLETED
                    all.handler.sendMessage(msg)
                    val msg2 = Message()
                    msg2.what = all.COMPLETED
                    expenditureList =
                        DatabaseAction.getInstance(context!!)?.getAllIncomesDao?.getAllExpense(MainActivity.username) as List<MyDatabase>
                    handler.sendMessage(msg2)
                    Looper.prepare()
                    Toast.makeText(context, "删除成功", Toast.LENGTH_SHORT).show()
                    Looper.loop()
                }.start()
            }
            false
        }
        popupMenu.show()
    }



    private fun refreshList() {
        Thread {
            expenditureList =
                context?.let { DatabaseAction.getInstance(it)?.getAllIncomesDao?.getAllExpense(MainActivity.username) } as List<MyDatabase>
            val msg = Message()
            msg.what = all.COMPLETED
            handler.sendMessage(msg)
        }.start()
    }

    companion object {
        val ARG_PARAM1: String? = "param1"
        val ARG_PARAM2: String? = "param2"
        var expenditureList:List<MyDatabase> = arrayListOf()
        var adapter:AccountItemAdapter = AccountItemAdapter(expenditureList)
        val handler: Handler = object : Handler(Looper.getMainLooper()) {
            override fun handleMessage(msg: Message) {
                if (msg.what == all.COMPLETED) {
                    adapter.setData(expenditureList)
                    adapter.notifyDataSetChanged()
                }
            }
        }
        fun newInstance(param1: String?, param2: String?): com.example.cashbook.ui.detailed_accounts.expenditure? {
            val fragment: com.example.cashbook.ui.detailed_accounts.expenditure = com.example.cashbook.ui.detailed_accounts.expenditure()
            val args = Bundle()
            args.putString(com.example.cashbook.ui.detailed_accounts.expenditure.ARG_PARAM1, param1)
            args.putString(com.example.cashbook.ui.detailed_accounts.expenditure.ARG_PARAM2, param2)
            fragment.arguments = args
            return fragment
        }
    }
}