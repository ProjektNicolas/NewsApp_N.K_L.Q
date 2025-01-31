package com.example.finalsproject_nkh_lq

data class NewsArticle(
    val title: String,
    val description: String,
    val urlToImage: String,
    val url: String,
    var isFavorite: Boolean = false
)