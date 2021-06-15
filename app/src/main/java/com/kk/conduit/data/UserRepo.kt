package com.kk.conduit.data

import com.kk.api.ConduitClients
import com.kk.api.models.entites.LoginData
import com.kk.api.models.entites.User
import com.kk.api.models.entites.UserCrede
import com.kk.api.models.request.LoginRequest
import com.kk.api.models.request.SignUpRequest
import com.kk.api.models.responce.UserResponce
import io.realworld.api.models.entities.UserUpdateData
import io.realworld.api.models.requests.UserUpdateRequest

object UserRepo {

    val api = ConduitClients.publicApi
    val authApi = ConduitClients.authApi

    suspend fun login(username : String , password : String): User? {
         val respoces =  api.loginUser(LoginRequest(LoginData(username,password)))


        ConduitClients.authToken = respoces.body()?.user?.token
        return respoces.body()?.user
    }

    suspend fun signup(username : String , password : String, email: String): UserResponce? {
        val respoces =  api.signupuser(SignUpRequest(UserCrede(email,password,username)))

        ConduitClients.authToken = respoces.body()?.user?.token
        return respoces.body()
    }

    suspend fun  getCurrentUser(token : String) : User? {
       ConduitClients.authToken =token
        return authApi.getCurrentUser().body()?.user
        }
    suspend fun  upadteuser(bio : String?
                            , username: String?,
                            image : String?,
                            email: String?,
                            password : String?) : User?{

        val respoces =  authApi.updateCurrentUser(UserUpdateRequest(UserUpdateData(bio,email,image,username,password)))
        return respoces.body()?.user

    }


}