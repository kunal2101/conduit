package io.realworld.api.services

import com.kk.api.models.responce.ArticleResponce
import com.kk.api.models.responce.ArticlesResponce
import com.kk.api.models.responce.UserResponce
import io.realworld.api.models.requests.UserUpdateRequest
import io.realworld.api.models.responses.ProfileResponse
import retrofit2.Response
import retrofit2.http.*

interface ConduitAuthAPI {

    @GET("user")
    suspend fun getCurrentUser(): Response<UserResponce>

    @PUT("user")
    suspend fun updateCurrentUser(
        @Body userUpdateRequest: UserUpdateRequest
    ): Response<UserResponce>

    @GET("profiles/{username}")
    suspend fun getProfile(
        @Path("username") username: String
    ): Response<ProfileResponse>

    @POST("profiles/{username}/follow")
    suspend fun followProfile(
        @Path("username") username: String
    ): Response<ProfileResponse>

    @DELETE("profiles/{username}/follow")
    suspend fun unfollowProfile(
        @Path("username") username: String
    ): Response<ProfileResponse>

    @GET("articles/feed")
    suspend fun getFeedArticles(): Response<ArticlesResponce>

    @POST("articles/{slug}/favorite")
    suspend fun favoriteArticle(
        @Path("slug") slug: String
    ): Response<ArticleResponce>

    @DELETE("articles/{slug}/favorite")
    suspend fun unfavoriteArticle(
        @Path("slug") slug: String
    ): Response<ArticleResponce>
}