package com.kk.api.models.request


import com.kk.api.models.entites.LoginData
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class LoginRequest(
    @Json(name = "user")
    val user: LoginData
)