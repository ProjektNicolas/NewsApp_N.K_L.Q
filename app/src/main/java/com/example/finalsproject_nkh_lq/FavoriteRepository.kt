package com.example.finalsproject_nkh_lq

import android.content.Context
import kotlinx.coroutines.flow.Flow

class FavoriteRepository(context: Context) {
    private val favoriteArticleDao = AppDatabase.getDatabase(context).favoriteArticleDao()

    suspend fun insert(favoriteArticle: FavoriteArticle) {
        favoriteArticleDao.insert(favoriteArticle)
    }

    suspend fun delete(favoriteArticle: FavoriteArticle) {
        favoriteArticleDao.delete(favoriteArticle)
    }

    fun getAllFavoriteArticles(): Flow<List<FavoriteArticle>> {
        return favoriteArticleDao.getAllFavoriteArticles()
    }

    suspend fun isFavorite(url: String): Boolean {
        return favoriteArticleDao.isFavorite(url)
    }
}