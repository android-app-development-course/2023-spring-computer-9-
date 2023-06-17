package com.example.cashbook.ui.statistics


import android.os.Bundle
import android.os.Handler
import android.os.Looper

import android.os.Message
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CalendarView
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.cashbook.R
import com.example.cashbook.DataBase.DatabaseAction
import com.example.cashbook.DataBase.MyDatabase
import com.example.cashbook.MainActivity
import lecho.lib.hellocharts.model.PieChartData
import lecho.lib.hellocharts.model.SliceValue
import lecho.lib.hellocharts.util.ChartUtils
import lecho.lib.hellocharts.view.PieChartView
import java.util.*


class DayView : Fragment() {
    private var pieChart //饼状图View
            : PieChartView? = null
    private var data //存放数据
            : PieChartData? = null
    private var im: TextView? = null
    private var om: TextView? = null
    private var am: TextView? = null
    private var db: List<MyDatabase>? = null
    var values: MutableList<SliceValue>? = null
    private var i: Long = 0
    private var o: Long = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
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
    ): View {
        val root: View = inflater.inflate(R.layout.statistics_day, container, false)
        pieChart = root.findViewById<PieChartView>(R.id.pie_chart)
        im = root.findViewById<TextView>(R.id.inM)
        om = root.findViewById<TextView>(R.id.outM)
        am = root.findViewById<TextView>(R.id.allM)
        pieChart?.isChartRotationEnabled = false
        val calendar = Calendar.getInstance()
        update(
            calendar[Calendar.YEAR], calendar[Calendar.MONTH] + 1,
            calendar[Calendar.DAY_OF_MONTH]
        )
        val calendarView = root.findViewById<CalendarView>(R.id.calendarView)
        calendarView.date = calendar.timeInMillis
        calendarView.setOnDateChangeListener { view, year, month, dayOfMonth ->
            update(
                year,
                month + 1,
                dayOfMonth
            )
        }
        return root
    }

    private fun update(year: Int, month: Int, dayOfMonth: Int) {
        Thread {
            i = context?.let {
                DatabaseAction.getInstance(it)?.getAllIncomesDao
                    ?.dayIn(year, month, dayOfMonth, MainActivity.username)
            }!!
            o = DatabaseAction.getInstance(context!!)?.getAllIncomesDao
                ?.dayOut(year, month, dayOfMonth, MainActivity.username)!!
            db = DatabaseAction.getInstance(context!!)?.getAllIncomesDao
                ?.getDayExpense(year, month, dayOfMonth, MainActivity.username) as List<MyDatabase>?
            values = ArrayList()
            for (d in db!!) {
                val sliceValue = SliceValue(
                    (d.money.toDouble() / 100).toFloat(),
                    ChartUtils.pickColor()
                )
                (values as ArrayList<SliceValue>).add(sliceValue)
            }
            data = PieChartData(values)
            data!!.setHasLabels(true)
            val msg = Message()
            msg.what = COMPLETED
            handler.sendMessage(msg)
        }.start()
    }

    val handler: Handler = object : Handler(Looper.getMainLooper()) {
        override fun handleMessage(msg: Message) {
            if (msg.what == COMPLETED) {
                im!!.text = String.format("%.2f", i.toDouble() / 100)
                om!!.text = String.format("%.2f", o.toDouble() / 100)
                am!!.text = String.format("%.2f", i.toDouble() / 100 - o.toDouble() / 100)
                pieChart!!.pieChartData = data
            }
        }
    }

    companion object {
        // TODO: Rename parameter arguments, choose names that match
        // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
        private const val ARG_PARAM1 = "param1"
        private const val ARG_PARAM2 = "param2"
        const val COMPLETED = -1

        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment BlankFragment1.
         */
        // TODO: Rename and change types and number of parameters
        fun newInstance(param1: String?, param2: String?): DayView {
            val fragment = DayView()
            val args = Bundle()
            args.putString(ARG_PARAM1, param1)
            args.putString(ARG_PARAM2, param2)
            fragment.arguments = args
            return fragment
        }
    }
}