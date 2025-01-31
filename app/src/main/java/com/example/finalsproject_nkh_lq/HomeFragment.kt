package com.example.finalsproject_nkh_lq

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.finalsproject_nkh_lq.databinding.FragmentHomeBinding
import kotlinx.coroutines.launch

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!
    private val newsRepository = NewsRepository()
    private lateinit var favoriteRepository: FavoriteRepository
    private lateinit var adapter: NewsAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        favoriteRepository = FavoriteRepository(requireContext())
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        adapter = NewsAdapter(mutableListOf(), requireContext())
        binding.newsRecyclerView.adapter = adapter
        binding.newsRecyclerView.layoutManager = LinearLayoutManager(context)

        lifecycleScope.launch {
            try {
                val apiArticles = newsRepository.getTopHeadlines()
                val articles = apiArticles.map { apiArticle ->
                    val isFavorite = favoriteRepository.isFavorite(apiArticle.url)
                    NewsArticle(
                        apiArticle.title,
                        apiArticle.description,
                        apiArticle.urlToImage ?: "",
                        apiArticle.url,
                        isFavorite
                    )
                }
                adapter.articles.clear()
                adapter.articles.addAll(articles)
                adapter.notifyDataSetChanged()
            } catch (e: Exception) {
                Log.e("HomeFragment", "Error fetching news", e)
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}