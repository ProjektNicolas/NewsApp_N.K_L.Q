package com.example.finalsproject_nkh_lq

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.ui.semantics.text
import androidx.fragment.app.Fragment
import com.example.finalsproject_nkh_lq.databinding.FragmentCategoriesBinding
import com.google.android.material.tabs.TabLayoutMediator

class CategoriesFragment : Fragment() {

    private var _binding: FragmentCategoriesBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentCategoriesBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val categories = listOf(
            Category("General", "general"),
            Category("Business", "business"),
            Category("Entertainment", "entertainment"),
            Category("Health", "health"),
            Category("Science", "science"),
            Category("Sports", "sports"),
            Category("Technology", "technology")
        )

        val adapter = CategoryAdapter(requireActivity(), categories)
        binding.viewPager.adapter = adapter

        TabLayoutMediator(binding.tabLayout, binding.viewPager) { tab, position ->
            tab.text = categories[position].name
        }.attach()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}