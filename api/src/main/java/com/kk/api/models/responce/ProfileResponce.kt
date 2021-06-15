package com.kk.api.models.responce


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import io.realworld.api.models.entities.Profile

@JsonClass(generateAdapter = true)
data class ProfileResponce(
    @Json(name = "profile")
    val profile: Profile
)