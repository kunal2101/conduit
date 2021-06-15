package com.kk.conduit.ui.auth

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kk.api.models.entites.User
import com.kk.conduit.data.UserRepo
import kotlinx.coroutines.launch

class AuthViewModel : ViewModel() {

    private  val _user = MutableLiveData<User>()

    val user : LiveData<User> = _user

    fun login(email : String, password : String){
      viewModelScope.launch {

          UserRepo.login(email,password).let {
              if (it != null) {
                  _user.postValue(it)
              }
          }
      }

    }

    fun signup(username : String , password : String , email: String){
        viewModelScope.launch {
      UserRepo.signup(username,email,password).let {
          _user.postValue(it?.user)
      }
        }
    }
    fun update (bio : String?
          , username: String?,
           image : String?,
            email: String?,
            password : String?
           ){viewModelScope.launch {
               UserRepo.upadteuser(bio,username,image,email,password).let {
                   _user.postValue(it)
               }
    }}

    fun getCurrentUser (token: String) =viewModelScope.launch {
     UserRepo.getCurrentUser(token).let {
         _user.postValue(it)
     }
    }
}