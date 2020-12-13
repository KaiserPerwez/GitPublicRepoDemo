package com.kaiser.gitpublicrepodemo.ui.screen.gitpublicrepos

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.kaiser.gitpublicrepodemo.R
import com.kaiser.gitpublicrepodemo.data.model.PublicRepoModel
import com.kaiser.gitpublicrepodemo.databinding.InflaterPublicReposBinding
import com.kaiser.gitpublicrepodemo.ui.base.BaseRecyclerAdapter

class PublicRepoListAdapter(listRepo: List<PublicRepoModel?>) :
    BaseRecyclerAdapter<PublicRepoModel?>(listRepo) {


    override fun onCreateViewHolderBase(
        parent: ViewGroup?,
        viewType: Int
    ): RecyclerView.ViewHolder {
        val binding = DataBindingUtil.inflate<InflaterPublicReposBinding>(
            LayoutInflater.from(parent?.context),
            R.layout.inflater_public_repos,
            parent,
            false
        )
        return PublicRepoViewHolder(binding)
    }

    override fun onBindViewHolderBase(holder: RecyclerView.ViewHolder?, position: Int) =
        (holder as PublicRepoViewHolder).bind(list[position])

    inner class PublicRepoViewHolder(private val binding: InflaterPublicReposBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: PublicRepoModel?) {
            binding.model = item
        }
    }
}