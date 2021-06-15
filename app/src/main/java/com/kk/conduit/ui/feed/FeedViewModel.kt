package com.kk.conduit.ui.feed

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kk.api.models.entites.Article
import com.kk.conduit.data.ArticleRepo
import kotlinx.coroutines.launch

class FeedViewModel : ViewModel(){

    private  val _feed = MutableLiveData<List<Article>>()

    val feed: LiveData<List<Article>> = _feed

    fun fetchGlobalFeed() = viewModelScope.launch {
       ArticleRepo.getGlobelFeed()?.body().let {
           if (it != null) {
               _feed.postValue(it.articles)
              val count =  it.articlesCount
               Log.d("FEED","Feed Count $count")
           }
       }

    }
    fun fetchMyFeed() = viewModelScope.launch {
         ArticleRepo.getMyFeed()?.body().let {
             if (it != null) {
                 _feed.postValue(it.articles)
                // Log.d("FEED","Feed Count $count")
             }
         }
    }
}