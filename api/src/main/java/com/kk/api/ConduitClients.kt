package com.kk.api

import com.kk.api.services.ConduitAPI
import io.realworld.api.services.ConduitAuthAPI
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.concurrent.TimeUnit

object ConduitClients {

     var authToken : String? = null

    private val authInterceptor = Interceptor{chain ->
        var  req = chain.request()
        authToken?.let {
            req = req.newBuilder()
                .header("Authorization", "Token $it")
                .build()
        }
        chain.proceed(req)
    }

    val okhttpbuider = OkHttpClient.Builder()


    val retrofit = Retrofit.Builder()
                   .baseUrl("https://conduit.productionready.io/api/")
                   .addConverterFactory(MoshiConverterFactory.create())


    val publicApi = retrofit
        .client(okhttpbuider.build())
        .build()
        .create(ConduitAPI::class.java)


    val authApi = retrofit
        .client(okhttpbuider.addInterceptor(authInterceptor).build())
        .build()
        .create(ConduitAuthAPI::class.java)

}