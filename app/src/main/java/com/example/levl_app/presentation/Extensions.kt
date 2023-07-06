package com.example.levl_app.presentation

import android.widget.ImageView
import com.bumptech.glide.Glide

fun ImageView.loadFromUrl(url: String?){

    url?.let {
        Glide.with(context)
            .load(it)
            .into(this)
    }



}