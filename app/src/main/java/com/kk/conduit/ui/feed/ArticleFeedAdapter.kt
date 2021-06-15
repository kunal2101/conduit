package com.kk.conduit.ui.feed

import android.util.Log
import android.util.Log.DEBUG
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ListAdapter
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.kk.api.models.entites.Article
import com.kk.conduit.R
import io.realworld.android.extensions.loadImage
import io.realworld.android.extensions.showDateInFormat

import io.realworld.android.extensions.timeStamp
import kotlinx.android.synthetic.main.fragment_article.view.*
import kotlinx.android.synthetic.main.item_list_articles.view.*

class ArticleFeedAdapter (val onArticleclicked : (slug : String) -> Unit): androidx.recyclerview.widget.ListAdapter<Article, ArticleFeedAdapter.ArticleViewHolder>(
    object : DiffUtil.ItemCallback<Article>(){
        override fun areItemsTheSame(oldItem: Article, newItem: Article): Boolean {
            return  oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: Article, newItem: Article): Boolean {
          return  oldItem.toString() == newItem.toString()
        }

    }

) {


    inner class ArticleViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView)





    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArticleViewHolder {
        val v: View = LayoutInflater.from(parent?.context)
            .inflate(R.layout.item_list_articles, parent, false)

        // Return the view holder
        return ArticleViewHolder(v)
    }
    override fun onBindViewHolder(holder: ArticleViewHolder, position: Int) {
             val article = getItem(position)

         holder.itemView.apply {
             tv_author_name.text = article.author.username
             tv_post_title.text  = article.title
             tv_post_detail.text = article.description
             tv_date.showDateInFormat (article.createdAt)

             img_author_profile_pic.loadImage(article.author.image,true)

             root.setOnClickListener { onArticleclicked(article.slug) }


         }



    }
}