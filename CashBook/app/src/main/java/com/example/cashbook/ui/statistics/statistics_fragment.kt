package com.example.cashbook.ui.statistics

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2
import com.example.cashbook.R
import com.example.cashbook.databinding.DetailedAccountsBinding
import com.example.cashbook.databinding.StatisticsBinding
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator


class statistics_fragment : Fragment() {
    private var binding: StatisticsBinding? = null
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = StatisticsBinding.inflate(inflater, container, false)
        val root: View = binding!!.root
        val viewPager2 = root.findViewById<ViewPager2>(R.id.viewpager2)
        viewPager2.adapter = ViewPagerAdapter2(this)
        val tabLayout = root.findViewById<TabLayout>(R.id.tabs2)
        val mediator = TabLayoutMediator(
            tabLayout, viewPager2
        ) { tab: TabLayout.Tab, position: Int ->
            when (position) {
                0 -> tab.text = "年视图"
                1 -> tab.text = "月视图"
                else -> tab.text = "日视图"
            }
        }
        mediator.attach()
        return root
    }

    @Deprecated("Deprecated in Java")
    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}

internal class ViewPagerAdapter2(fragment: Fragment) :
    FragmentStateAdapter(fragment) {
    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> YearView.newInstance("fragment1", "f1")
            1 -> MonthView.newInstance("fragment2", "f2")
            else -> DayView.newInstance("fragment3", "f3")
        }
    }

    override fun getItemCount(): Int {
        return 3
    }
}