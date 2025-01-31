package com.example.finalsproject_nkh_lq

class NewsRepository {
    private val newsApiService = RetrofitClient.newsApiService

    suspend fun getTopHeadlines(): List<ApiArticle> {
        val response = newsApiService.getTopHeadlines()
        if (response.isSuccessful) {
            return response.body()?.articles ?: emptyList()
        } else {
            throw Exception("Error fetching news")
        }
    }
    suspend fun getTopHeadlinesByCategory(category: String): List<ApiArticle> {
        val response = newsApiService.getTopHeadlinesByCategory(category)
        if (response.isSuccessful) {
            return response.body()?.articles ?: emptyList()
        } else {
            throw Exception("Error fetching news")
        }
    }
}