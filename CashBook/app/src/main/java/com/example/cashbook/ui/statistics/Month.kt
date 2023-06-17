package com.example.cashbook.ui.statistics


import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.os.Message
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.bigkoo.pickerview.builder.TimePickerBuilder
import com.example.cashbook.R
import com.example.cashbook.DataBase.DatabaseAction
import com.example.cashbook.MainActivity
import lecho.lib.hellocharts.model.*
import lecho.lib.hellocharts.view.LineChartView
import java.text.SimpleDateFormat
import java.util.*


class MonthView : Fragment() {
    private var lineChartView: LineChartView? = null
    private var yy = 0
    private var mm = 0
    private var mi: Long = 0
    private var mo: Long = 0
    private var im: TextView? = null
    private var om: TextView? = null
    private var am: TextView? = null
    var axisX = Axis()
    var axisY = Axis()
    private val data = LineChartData()
    private val dayList: MutableList<AxisValue> = ArrayList()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        for (i in 0..30) dayList.add(AxisValue(i.toFloat()).setLabel((i + 1).toString() + "日"))
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
        val root: View = inflater.inflate(R.layout.statistics_month, container, false)
        im = root.findViewById<TextView>(R.id.minM)
        om = root.findViewById<TextView>(R.id.moutM)
        am = root.findViewById<TextView>(R.id.mallM)
        lineChartView = root.findViewById<LineChartView>(R.id.monthChart)
        val button = root.findViewById<Button>(R.id.changeMonth)
        yy = Calendar.getInstance()[Calendar.YEAR]
        mm = Calendar.getInstance()[Calendar.MONTH] + 1
        button.text = yy.toString() + "年" + mm + "月"
        val pvTime = TimePickerBuilder(
            context
        ) { date: Date?, v: View? ->
            yy = SimpleDateFormat("yyyy").format(date).toInt()
            mm = SimpleDateFormat("MM").format(date).toInt()
            button.text = yy.toString() + "年"
            update(yy, mm)
        }.setType(booleanArrayOf(true, true, false, false, false, false)).build()
        button.setOnClickListener { v: View? -> pvTime.show() }
        axisX.values = dayList
        axisX.name = "日期"
        axisY.name = "结余"
        data.axisYLeft = axisY
        data.axisXBottom = axisX
        update(yy, mm)
        return root
    }

    private fun update(year: Int, month: Int) {
        Thread {
            val lines: MutableList<Line> =
                ArrayList()
            val values: MutableList<PointValue> =
                ArrayList()
            mi = 0
            mo = 0
            for (i in 0..30) {
                val yit: Long? = context?.let {
                    DatabaseAction.getInstance(it)?.getAllIncomesDao
                        ?.getDayI(year, month, i + 1, MainActivity.username)
                }
                val yot: Long? = context?.let {
                    DatabaseAction.getInstance(it)?.getAllIncomesDao
                        ?.getDayO(year, month, i + 1, MainActivity.username)
                }
                if (yit != null) {
                    mi += yit
                }
                if (yot != null) {
                    mo += yot
                }
                if (yit != null) {
                    values.add(PointValue(i.toFloat(), ((yit - yot!!) / 100).toFloat()))
                }
            }
            lines.add(Line(values))
            data.lines = lines
            val msg = Message()
            msg.what = COMPLETED
            handler.sendMessage(msg)
        }.start()
    }

    val handler: Handler = object : Handler(Looper.getMainLooper()) {
        override fun handleMessage(msg: Message) {
            if (msg.what == COMPLETED) {
                im!!.text = String.format("%.2f", mi.toDouble() / 100)
                om!!.text = String.format("%.2f", mo.toDouble() / 100)
                am!!.text = String.format("%.2f", mi.toDouble() / 100 - mo.toDouble() / 100)
                lineChartView!!.lineChartData = data
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
        fun newInstance(param1: String?, param2: String?): MonthView {
            val fragment = MonthView()
            val args = Bundle()
            args.putString(ARG_PARAM1, param1)
            args.putString(ARG_PARAM2, param2)
            fragment.arguments = args
            return fragment
        }
    }
}