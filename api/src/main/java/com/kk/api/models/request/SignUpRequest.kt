package com.kk.api.models.request


import com.kk.api.models.entites.UserCrede
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class SignUpRequest(
    @Json(name = "user")
    val user: UserCrede
)