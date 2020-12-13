package com.kaiser.gitpublicrepodemo.ui.gitpublicrepos

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.kaiser.gitpublicrepodemo.data.repository.IGithubRepository
import com.kaiser.gitpublicrepodemo.ui.gitsearch.SearchUserViewModel

@Suppress("UNCHECKED_CAST")
class PublicRepoViewModelFactory(private val repository: IGithubRepository): ViewModelProvider.NewInstanceFactory() {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return PublicRepoViewModel(repository) as T
    }
}