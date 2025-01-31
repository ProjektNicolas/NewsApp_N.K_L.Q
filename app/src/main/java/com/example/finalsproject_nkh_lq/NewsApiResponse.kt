package com.example.finalsproject_nkh_lq

data class NewsApiResponse(
    val status: String,
    val totalResults: Int,
    val articles: List<ApiArticle>
)

data class ApiArticle(
    val title: String,
    val description: String,
    val urlToImage: String?,
    val url: String
)