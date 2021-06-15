package com.kk.api.models.responce


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class TagResponce(
    @Json(name = "tags")
    val tags: List<String>
)