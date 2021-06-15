package com.kk.api.models.responce


import com.kk.api.models.entites.Article
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ArticleResponce(
    @Json(name = "article")
    val article: Article
)