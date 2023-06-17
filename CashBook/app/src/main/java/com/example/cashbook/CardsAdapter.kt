package com.example.cashbook

import android.content.Context
import android.content.res.ColorStateList
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat

class CardsAdapter(
    var context: Context,
    private val cardsList: ArrayList<Card>,
    private var selPos: Int
) :
    BaseAdapter() {
    private val inflater: LayoutInflater



    init {
        inflater = LayoutInflater.from(context)
    }

    fun setSelPos(selPos: Int) {
        this.selPos = selPos
    }

    override fun getCount(): Int {
        return cardsList.size
    }

    override fun getItem(position: Int): Any {
        return cardsList[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        var view: View? = null
        var myHolder:ViewHolder ?= null

        if(convertView == null){
            myHolder = ViewHolder()
            view = LayoutInflater.from(context).inflate(R.layout.card_item,null)
            myHolder.cardImage = view.findViewById(R.id.typeIcon)
            myHolder.typeName = view.findViewById(R.id.typeName)
            view.tag = myHolder
        }else{
            view = convertView
            myHolder = view.tag as ViewHolder
        }

        myHolder.cardImage?.setImageResource(cardsList[position].getImageId())
        myHolder.typeName?.text = cardsList[position].getName()
        if (selPos == position) myHolder.cardImage?.imageTintList = ColorStateList.valueOf(
            ContextCompat.getColor(
                view!!.context, R.color.teal_200
            )
        ) else myHolder.cardImage?.imageTintList = ColorStateList.valueOf(
            ContextCompat.getColor(
                view!!.context, R.color.gray
            )
        )

        return view
    }

    class ViewHolder {
        var cardImage: ImageView? = null
        var typeName: TextView? = null
    }
}