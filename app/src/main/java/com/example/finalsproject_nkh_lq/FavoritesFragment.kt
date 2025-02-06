package com.example.finalsproject_nkh_lq

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.finalsproject_nkh_lq.databinding.FragmentFavoritesBinding
import kotlinx.coroutines.launch

private val Any.favoritesRecyclerView: Any
    get() {
        TODO("Not yet implemented")
    }

class FavoritesFragment : Fragment() {

    private var _binding: FragmentFavoritesBinding? = null
    private val binding get() = _binding!!
    private lateinit var favoriteRepository: FavoriteRepository
    private lateinit var adapter: NewsAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentFavoritesBinding.inflate(inflater, container, false)
        favoriteRepository = FavoriteRepository(requireContext())
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        adapter = NewsAdapter(mutableListOf(), requireContext())
        binding.favoritesRecyclerView.adapter = adapter
        binding.favoritesRecyclerView.layoutManager = LinearLayoutManager(context)

        viewLifecycleOwner.lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                favoriteRepository.getAllFavoriteArticles().collect { favoriteArticles ->
                    val newsArticles = favoriteArticles.map { favoriteArticle ->
                        NewsArticle(
                            favoriteArticle.title,
                            favoriteArticle.description,
                            favoriteArticle.urlToImage,
                            favoriteArticle.url,
                            true
                        )
                    }
                    adapter.articles.clear()
                    adapter.articles.addAll(newsArticles)
                    adapter.notifyDataSetChanged()
                }
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}