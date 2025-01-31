package com.example.finalsproject_nkh_lq

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsApiService {
    @GET("top-headlines")
    suspend fun getTopHeadlinesByCategory(
        @Query("category") category: String,
        @Query("country") country: String = "us",
        @Query("apiKey") apiKey: String = "YOUR_API_KEY"
    ): Response<NewsApiResponse>
}