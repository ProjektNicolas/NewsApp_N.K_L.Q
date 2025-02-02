package com.example.finalsproject_nkh_lq

private val Any.articles: List<ApiArticle>?
    get() {
        TODO("Not yet implemented")
    }
private val Any.isSuccessful: Boolean
    get() {
        TODO("Not yet implemented")
    }

class NewsRepository {
    private fun getNewsApiService() = RetrofitClient.newsApiService

    suspend fun getTopHeadlines(): List<ApiArticle> {
        val response = getNewsApiService().getTopHeadlines()
        if (response.isSuccessful) {
            return response.body()?.articles ?: emptyList()
        } else {
            throw Exception("Error fetching news")
        }
    }
    suspend fun getTopHeadlinesByCategory(category: String): List<ApiArticle> {
        val response = getNewsApiService().getTopHeadlinesByCategory(category)
        if (response.isSuccessful) {
            return response.body()?.articles ?: emptyList()
        } else {
            throw Exception("Error fetching news")
        }
    }
}

private fun Any.body(): Any {
        TODO("Not yet implemented")
}
