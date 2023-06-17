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
import com.bigkoo.pickerview.view.TimePickerView
import com.example.cashbook.R
import com.example.cashbook.DataBase.DatabaseAction
import com.example.cashbook.MainActivity
import lecho.lib.hellocharts.model.*
import lecho.lib.hellocharts.view.LineChartView
import java.text.SimpleDateFormat
import java.util.*


class YearView : Fragment() {
    private var lineChartView: LineChartView? = null
    private var yy = 0
    private var yi: Long = 0
    private var yo: Long = 0
    private var im: TextView? = null
    private var om: TextView? = null
    private var am: TextView? = null
    var axisX = Axis()
    var axisY = Axis()
    private val data = LineChartData()
    private val monthList: MutableList<AxisValue> = ArrayList()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        for (i in 0..11) monthList.add(AxisValue(i.toFloat()).setLabel((i + 1).toString() + "月"))
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
        val root: View = inflater.inflate(R.layout.statistics_year, container, false)
        im = root.findViewById<TextView>(R.id.yinM)
        om = root.findViewById<TextView>(R.id.youtM)
        am = root.findViewById<TextView>(R.id.yallM)
        lineChartView = root.findViewById<LineChartView>(R.id.yearChart)
        val button = root.findViewById<Button>(R.id.changeYear)
        yy = Calendar.getInstance()[Calendar.YEAR]
        button.text = yy.toString() + "年"
        val pvTime: TimePickerView = TimePickerBuilder(context) { date, v ->
            yy = SimpleDateFormat("yyyy").format(date).toInt()
            button.text = yy.toString() + "年"
            update(yy)
        }.setType(booleanArrayOf(true, false, false, false, false, false)).build()
        button.setOnClickListener { v: View? -> pvTime.show() }
        axisX.values = monthList
        axisX.name = "月份"
        axisY.name = "结余"
        data.axisYLeft = axisY
        data.axisXBottom = axisX
        update(yy)
        return root
    }

    private fun update(year: Int) {
        Thread {
            val lines: MutableList<Line> =
                ArrayList()
            val values: MutableList<PointValue> =
                ArrayList()
            yi = 0
            yo = 0
            for (i in 0..11) {
                val yit: Long? = context?.let {
                    DatabaseAction.getInstance(it)?.getAllIncomesDao
                        ?.getMonthI(year, i + 1, MainActivity.username)
                }
                val yot: Long? = context?.let {
                    DatabaseAction.getInstance(it)?.getAllIncomesDao
                        ?.getMonthO(year, i + 1, MainActivity.username)
                }
                if (yit != null) {
                    yi += yit
                }
                if (yot != null) {
                    yo += yot
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
                im!!.text = String.format("%.2f", yi.toDouble() / 100)
                om!!.text = String.format("%.2f", yo.toDouble() / 100)
                am!!.text = String.format("%.2f", yi.toDouble() / 100 - yo.toDouble() / 100)
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
        fun newInstance(param1: String?, param2: String?): YearView {
            val fragment = YearView()
            val args = Bundle()
            args.putString(ARG_PARAM1, param1)
            args.putString(ARG_PARAM2, param2)
            fragment.arguments = args
            return fragment
        }
    }
}
