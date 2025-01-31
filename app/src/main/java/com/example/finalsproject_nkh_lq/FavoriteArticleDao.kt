package com.example.finalsproject_nkh_lq

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface FavoriteArticleDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(favoriteArticle: FavoriteArticle)

    @Delete
    suspend fun delete(favoriteArticle: FavoriteArticle)

    @Query("SELECT * FROM favorite_articles")
    fun getAllFavoriteArticles(): Flow<List<FavoriteArticle>>

    @Query("SELECT EXISTS(SELECT 1 FROM favorite_articles WHERE url = :url)")
    suspend fun isFavorite(url: String): Boolean
}