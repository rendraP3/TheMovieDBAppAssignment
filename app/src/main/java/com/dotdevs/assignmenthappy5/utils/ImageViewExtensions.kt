package com.dotdevs.assignmenthappy5.utils

import android.widget.ImageView
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.dotdevs.assignmenthappy5.base.GlideApp
import com.dotdevs.assignmenthappy5.constants.RestConfig

fun ImageView.setPosterImage(url: String) {
    GlideApp.with(this.context)
        .load(RestConfig.POSTER_W500_IMAGE_PATH + url)
        .transition(DrawableTransitionOptions.withCrossFade())
        .into(this)
}

fun ImageView.setHeroImage(url: String) {
    GlideApp.with(this.context)
        .load(RestConfig.POSTER_ORIGINAL_IMAGE_PATH + url)
        .transition(DrawableTransitionOptions.withCrossFade())
        .into(this)
}