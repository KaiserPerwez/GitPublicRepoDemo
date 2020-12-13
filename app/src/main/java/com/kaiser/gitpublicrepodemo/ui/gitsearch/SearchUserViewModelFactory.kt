package com.kaiser.gitpublicrepodemo.ui.gitsearch

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.kaiser.gitpublicrepodemo.data.repository.IGithubRepository

@Suppress("UNCHECKED_CAST")
class SearchUserViewModelFactory(private val repository: IGithubRepository):ViewModelProvider.NewInstanceFactory() {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return SearchUserViewModel(repository) as T
    }
}
