package com.kk.conduit.ui.articles

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kk.api.models.entites.Article
import com.kk.conduit.data.ArticleRepo
import kotlinx.coroutines.launch

class ArticleViewModel : ViewModel() {

    private  val _article = MutableLiveData<Article>()

    val article : LiveData<Article> = _article

    fun fetchArticlefromid(Id : String) = viewModelScope.launch {
        ArticleRepo.getArticleBySlug(Id).let { it ->
            _article.postValue(it?.article)

        }
    }

}