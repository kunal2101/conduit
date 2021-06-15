package com.kk.conduit.ui.articles

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.kk.conduit.R
import io.realworld.android.extensions.loadImage
import io.realworld.android.extensions.setImage
import io.realworld.android.extensions.showDateInFormat
import io.realworld.android.extensions.timeStamp

import kotlinx.android.synthetic.main.fragment_article.view.*
import kotlinx.android.synthetic.main.item_list_articles.view.*

class ArticleFragment : Fragment() {

    private  var  _articleViewModel = ArticleViewModel()
    private var articleId: String? = null
    private  lateinit var root : View

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _articleViewModel = ViewModelProvider(this).get(ArticleViewModel::class.java)

         root = inflater.inflate(R.layout.fragment_article,container,false)
        arguments.let {
            articleId = it?.getString(resources.getString(R.string.arg_articel_id))
            Toast.makeText(context,"This is article id ${articleId}",Toast.LENGTH_LONG).show()
        }
        articleId?.let { _articleViewModel.fetchArticlefromid(it) }

        return  root
    }
   /* fun ImageView.setImage(url:String, context: Context){
        Glide.with(context).load(url).into(this)
    }*/
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _articleViewModel.article.observe({lifecycle}){
            root.apply {
                titleTextView.text = it.title
                authorTextView.text = it.author.username
                bodyTextView.text   = it.body
               // dateTextView.timeStamp = it.createdAt
               // dateTextView.showDateInFormat(it.createdAt + "Hi ")

                dateTextView.showDateInFormat (it.createdAt+ "HI")

                // avatarImageView.setImageDrawable(resources.getDrawable(R.drawable.img_demo))
                val urls = "http://www.cartoonbucket.com/wp-content/uploads/2015/05/Laughing-Image-Of-Tom-And-Jerry-600x761.jpg"

               avatarImageView?.loadImage(it.author.image,true)

             /*   Glide.with(context)
                    .load(urls)
                    .into(avatarImageView)*/
               // avatarImageView.loadImage(urls,true)
                dateTextView.text = it.createdAt // TODO : add date converted

            }
        }

    }
}