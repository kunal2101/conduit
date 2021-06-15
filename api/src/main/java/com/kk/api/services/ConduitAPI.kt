package com.kk.api.services

import com.kk.api.models.entites.UserCrede
import com.kk.api.models.request.LoginRequest
import com.kk.api.models.request.SignUpRequest
import com.kk.api.models.responce.ArticleResponce
import com.kk.api.models.responce.ArticlesResponce
import com.kk.api.models.responce.TagResponce
import com.kk.api.models.responce.UserResponce
import retrofit2.Response
import retrofit2.http.*

interface ConduitAPI {

    @POST("users")
    suspend fun signupuser(
        @Body userCrede: SignUpRequest
    ) : Response<UserResponce>


    @POST("users/login")
    suspend fun loginUser(
        @Body userCreds: LoginRequest
    ): Response<UserResponce>



    @GET("articles")
   suspend fun getarticles(
    @Query("author" ) author : String? = null,
    @Query("favourited") favourited : String? = null,
     @Query("tag") tag : String ? = null

    ) : Response<ArticlesResponce>


    @GET("articles/{slug}")
    suspend fun getArticleBySlug(
        @Path("slug") slug: String
    ): Response<ArticleResponce>

    @GET("tags")
    suspend fun getTags(): Response<TagResponce>
}