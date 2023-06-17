package com.example.cashbook.ui.detailed_accounts

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2
import com.example.cashbook.MainActivity
import com.example.cashbook.R
import com.example.cashbook.databinding.DetailedAccountsBinding
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator


@Suppress("DEPRECATION")
class detailed_accounts_fragment : Fragment() {

    private var binding: DetailedAccountsBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DetailedAccountsBinding.inflate(inflater, container, false)
        val root: View = binding!!.root
        //binding!!.floatingAddButton.setOnClickListener { view -> show() }
        val fabAdd: FloatingActionButton =
            root.findViewById<FloatingActionButton>(R.id.floatingAddButton)
        fabAdd.setOnClickListener {
            if (MainActivity.if_login){
                val intent = Intent(this@detailed_accounts_fragment.context, add_accounts::class.java)
                startActivityForResult(intent,1)
            }
            else{
                Toast.makeText(context, "请先登录！", Toast.LENGTH_LONG).show()
            }
        }
        val viewPager2 = root.findViewById<ViewPager2>(R.id.viewpager)
        viewPager2.adapter = com.example.cashbook.ui.detailed_accounts.ViewPagerAdapter(this)
        val tabLayout = root.findViewById<TabLayout>(R.id.tabs)
        val mediator = TabLayoutMediator(
            tabLayout!!, viewPager2
        ) { tab: TabLayout.Tab, position: Int ->
            when (position) {
                0 -> {
                    tab.text = "全部"
                    tab.setIcon(R.drawable.ic_all)
                }
                1 -> {
                    tab.text = "支出"
                    tab.setIcon(R.drawable.ic_expenditure)
                }
                else -> {
                    tab.text = "收入"
                    tab.setIcon(R.drawable.ic_income)
                }
            }
        }
        mediator.attach()
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }


}
internal class ViewPagerAdapter(fragment: Fragment) :
    FragmentStateAdapter(fragment) {
    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> all.newInstance("fragment1", "f1")!!
            1 -> expenditure.newInstance("fragment2", "f2")!!
            else -> income.newInstance("fragment3", "f3")!!
        }
    }

    override fun getItemCount(): Int {
        return 3
    }
}