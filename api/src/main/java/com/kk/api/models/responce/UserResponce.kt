package com.kk.api.models.responce


import com.kk.api.models.entites.User
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class UserResponce(
    @Json(name = "user")
    val user: User
)