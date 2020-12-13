package com.kaiser.gitpublicrepodemo.utils

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.kaiser.gitpublicrepodemo.R

object BindingAdapters {
    @JvmStatic
    @BindingAdapter(value = ["image_url"], requireAll = false)
    fun ImageView.setImage(imageUrl: String?) {
        if (imageUrl == null) return
        Glide.with(this.context).load(imageUrl)
            .placeholder(R.drawable.ic_account_circle_24)
            .into(this)
    }
}