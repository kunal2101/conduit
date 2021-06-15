package io.realworld.android.extensions

import android.content.Context
import android.widget.ImageView
import com.bumptech.glide.Glide


fun ImageView.setImage(url:String, context: Context){
    Glide.with(context).load(url).into(this)
}

fun ImageView.loadImage(uri: String, circleCrop: Boolean = false) {
    if (circleCrop) {
        Glide.with(this).load(uri).circleCrop().into(this)
    } else {
        Glide.with(this).load(uri).into(this)
    }


}