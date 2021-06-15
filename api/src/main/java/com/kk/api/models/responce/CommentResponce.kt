package com.kk.api.models.responce


import com.kk.api.models.entites.Comment
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class CommentResponce(
    @Json(name = "comment")
    val comment: Comment
)