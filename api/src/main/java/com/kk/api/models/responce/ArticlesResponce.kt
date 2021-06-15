package com.kk.api.models.responce


import com.kk.api.models.entites.Article
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ArticlesResponce(
    @Json(name = "articles")
    val articles: List<Article>,
    @Json(name = "articlesCount")
    val articlesCount: Int
)