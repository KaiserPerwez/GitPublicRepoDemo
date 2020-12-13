package com.kaiser.gitpublicrepodemo.ui.bindingadapter

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.kaiser.gitpublicrepodemo.R
import com.kaiser.gitpublicrepodemo.data.model.PublicRepoModel
import com.kaiser.gitpublicrepodemo.ui.screen.gitpublicrepos.PublicRepoListAdapter

object BindingAdapters {
    @JvmStatic
    @BindingAdapter(value = ["image_url"], requireAll = false)
    fun ImageView.setImage(imageUrl: String?) {
        if (imageUrl == null) return
        Glide.with(this.context).load(imageUrl)
            .placeholder(R.drawable.ic_account_circle_24)
            .into(this)
    }

    @JvmStatic
    @BindingAdapter(value = ["public_repos"], requireAll = true)
    fun RecyclerView.loadData(data: List<PublicRepoModel?>) {
        this.adapter = PublicRepoListAdapter(data)
    }
}