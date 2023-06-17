package com.example.cashbook

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.cashbook.DataBase.MyDatabase
import java.util.*

class AccountItemAdapter(itemsList: List<MyDatabase>) :
    RecyclerView.Adapter<AccountItemAdapter.ViewHolder>() {
    private var itemsList: List<MyDatabase>

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var itemIcon: ImageView
        var itemType: TextView
        var itemDate: TextView
        var itemMoney: TextView

        init {
            itemIcon = view.findViewById<ImageView>(R.id.itemIcon)
            itemType = view.findViewById<TextView>(R.id.itemType)
            itemDate = view.findViewById<TextView>(R.id.itemDate)
            itemMoney = view.findViewById<TextView>(R.id.moneyAcc)
        }
    }

    fun setData(itemsList: List<MyDatabase>) {
        this.itemsList = itemsList
    }

    interface OnItemClickListener {
        fun onClick(position: Int, v: View?)
        fun onLongClick(position: Int, v: View?)
    }

    private var mOnItemClickListener: OnItemClickListener? = null

    init {
        this.itemsList = itemsList
    }

    fun setOnItemClickListener(onItemClickListener: OnItemClickListener?) {
        mOnItemClickListener = onItemClickListener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view: View =
            LayoutInflater.from(parent.context).inflate(R.layout.account_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val cd: MyDatabase = itemsList[position]
        holder.itemMoney.text =
            (if (cd.inOut) "-" else "+") + cd.money.toString().substring(0,cd.money.toString().length-2) + "." + cd.money.toString().substring(cd.money.toString().length-2)
        holder.itemDate.text = java.lang.String.format(
            Locale.CHINA,
            "%d年%d月%d日",
            cd.year,
            cd.month,
            cd.day
        )
        holder.itemType.setText(if (cd.remark.equals("")) cd.type else cd.remark)
        when (cd.type) {
            "餐饮" -> holder.itemIcon.setImageResource(R.drawable.ic_expenditure_food)
            "购物" -> holder.itemIcon.setImageResource(R.drawable.ic_expenditure_shopping)
            "日用" -> holder.itemIcon.setImageResource(R.drawable.ic_expenditure_daily)
            "旅行" -> holder.itemIcon.setImageResource(R.drawable.ic_expenditure_travel)
            "水果" -> holder.itemIcon.setImageResource(R.drawable.ic_expenditure_fruit)
            "礼物" -> holder.itemIcon.setImageResource(R.drawable.ic_expenditure_gift)
            "就医" -> holder.itemIcon.setImageResource(R.drawable.ic_expenditure_doctor)
            "工资" -> holder.itemIcon.setImageResource(R.drawable.ic_income_salary)
            "投资" -> holder.itemIcon.setImageResource(R.drawable.ic_income_investment)
            "分红" -> holder.itemIcon.setImageResource(R.drawable.ic_income_bonus)
            "转账" -> holder.itemIcon.setImageResource(R.drawable.ic_income_transfer_accounts)
            else -> holder.itemIcon.setImageResource(R.drawable.ic_expenditure_other)
        }
        if (mOnItemClickListener != null) {
            holder.itemView.setOnClickListener { v: View? ->
                mOnItemClickListener!!.onClick(
                    holder.adapterPosition,
                    v
                )
            }
            holder.itemView.setOnLongClickListener { v: View? ->
                mOnItemClickListener!!.onLongClick(holder.adapterPosition, v)
                true
            }
        }
    }

    override fun getItemCount(): Int {
        return itemsList.size
    }
}