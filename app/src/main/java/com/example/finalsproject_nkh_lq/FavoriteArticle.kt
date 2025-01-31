package com.example.finalsproject_nkh_lq

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "favorite_articles")
data class FavoriteArticle(
    @PrimaryKey val url: String,
    val title: String,
    val description: String,
    val urlToImage: String
)