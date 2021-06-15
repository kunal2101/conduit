package com.kk.conduit.data

import com.kk.api.ConduitClients

object ArticleRepo {

    val api = ConduitClients.publicApi
    val apiAuth = ConduitClients.authApi

    suspend fun getGlobelFeed() = api.getarticles()

    suspend fun  getMyFeed() =  apiAuth.getFeedArticles()

    suspend fun  getArticleBySlug(Id : String) =  api.getArticleBySlug(Id).body()
}