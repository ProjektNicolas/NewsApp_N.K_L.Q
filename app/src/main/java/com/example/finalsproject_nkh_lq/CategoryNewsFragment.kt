package com.example.finalsproject_nkh_lq

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.viewbinding.ViewBinding
import com.example.finalsproject_nkh_lq.databinding.FragmentCategoryNewsBinding
import kotlinx.coroutines.launch

var Any.layoutManager: LinearLayoutManager
    get() {
        TODO("Not yet implemented")
    }
    set(value) {}
var Any.adapter: NewsAdapter
    get() {
        TODO("Not yet implemented")
    }
    set(value) {}
private val ViewBinding.categoryNewsRecyclerView: Any
    get() {
        TODO("Not yet implemented")
    }

class CategoryNewsFragment : Fragment() {

    private var _binding: FragmentCategoryNewsBinding? = null
    private val binding get() = _binding!!
    private val newsRepository = NewsRepository()
    private lateinit var favoriteRepository: FavoriteRepository
    private lateinit var categoryQuery: String
    private lateinit var adapter: NewsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        categoryQuery = arguments?.getString(ARG_CATEGORY_QUERY) ?: ""
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentCategoryNewsBinding.inflate(inflater, container, false)
        favoriteRepository = FavoriteRepository(requireContext())
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        adapter = NewsAdapter(mutableListOf(), requireContext())
        binding.categoryNewsRecyclerView.adapter = adapter
        binding.categoryNewsRecyclerView.layoutManager = LinearLayoutManager(context)

        lifecycleScope.launch {
            try {
                val apiArticles = newsRepository.getTopHeadlinesByCategory(categoryQuery)
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
                Log.e("CategoryNewsFragment", "Error fetching news", e)
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {
        private const val ARG_CATEGORY_QUERY = "category_query"

        fun newInstance(categoryQuery: String): CategoryNewsFragment {
            val fragment = CategoryNewsFragment()
            val args = Bundle().apply {
                putString(ARG_CATEGORY_QUERY, categoryQuery)
            }
            fragment.arguments = args
            return fragment
        }
    }
}