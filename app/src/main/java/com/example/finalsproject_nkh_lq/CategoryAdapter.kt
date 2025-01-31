package com.example.finalsproject_nkh_lq

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

class CategoryAdapter(fragmentActivity: FragmentActivity, private val categories: List<Category>) :
    FragmentStateAdapter(fragmentActivity) {

    override fun getItemCount(): Int = categories.size

    override fun createFragment(position: Int): Fragment {
        val category = categories[position]
        return CategoryNewsFragment.newInstance(category.query)
    }
}