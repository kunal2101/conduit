package com.kk.api.models.responce


import com.kk.api.models.entites.Comment
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class CommentsResponce(
    @Json(name = "comments")
    val comments: List<Comment>
)