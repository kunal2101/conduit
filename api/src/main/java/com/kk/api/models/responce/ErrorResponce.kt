package com.kk.api.models.responce


import com.kk.api.models.entites.Error
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ErrorResponce(
    @Json(name = "errors")
    val error: Error
)