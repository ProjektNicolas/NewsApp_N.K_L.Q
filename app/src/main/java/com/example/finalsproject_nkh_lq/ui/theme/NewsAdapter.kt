package com.example.finalsproject_nkh_lq

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.compose.ui.semantics.text
import androidx.lifecycle.lifecycleScope
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import androidx.wear.compose.foundation.size
import com.bumptech.glide.Glide
import com.example.finalsproject_nkh_lq.databinding.NewsArticleItemBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class NewsAdapter(
    val articles: MutableList<NewsArticle>,
    private val context: Context
) :
    RecyclerView.Adapter<NewsAdapter.NewsViewHolder>() {

    private val favoriteRepository = FavoriteRepository(context)

    class NewsViewHolder(val binding: NewsArticleItemBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        val binding = NewsArticleItemBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return NewsViewHolder(binding)
    }

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        val article = articles[position]
        holder.binding.articleTitleTextView.text = article.title
        holder.binding.articleDescriptionTextView.text = article.description
        Glide.with(holder.itemView.context)
            .load(article.urlToImage)
            .into(holder.binding.articleImageView)

        holder.itemView.setOnClickListener {
            val action = HomeFragmentDirections.actionHomeFragmentToWebViewFragment(article.url)
            holder.itemView.findNavController().navigate(action)
        }

        holder.binding.favoriteButton.setImageResource(
            if (article.isFavorite) R.drawable.ic_favorite else R.drawable.ic_favorite_border
        )

        holder.binding.favoriteButton.setOnClickListener {
            val favoriteArticle = FavoriteArticle(
                article.url,
                article.title,
                article.description,
                article.urlToImage
            )
            if (article.isFavorite) {
                holder.binding.favoriteButton.setImageResource(R.drawable.ic_favorite_border)
                article.isFavorite = false
                CoroutineScope(Dispatchers.IO).launch {
                    favoriteRepository.delete(favoriteArticle)
                }
            } else {
                holder.binding.favoriteButton.setImageResource(R.drawable.ic_favorite)
                article.isFavorite = true
                CoroutineScope(Dispatchers.IO).launch {
                    favoriteRepository.insert(favoriteArticle)
                }
            }
        }
    }

    override fun getItemCount(): Int = articles.size
}