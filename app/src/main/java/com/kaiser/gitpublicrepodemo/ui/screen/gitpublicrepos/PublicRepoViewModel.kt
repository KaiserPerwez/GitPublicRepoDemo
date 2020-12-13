package com.kaiser.gitpublicrepodemo.ui.screen.gitpublicrepos

import androidx.databinding.ObservableField
import androidx.lifecycle.ViewModel
import com.kaiser.gitpublicrepodemo.data.model.PublicRepoModel
import com.kaiser.gitpublicrepodemo.data.repository.IGithubRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class PublicRepoViewModel(private val repository: IGithubRepository):ViewModel() {
    val userRepos = ObservableField<List<PublicRepoModel>>(emptyList())
    val isBusy = ObservableField<Boolean>()

    suspend fun fetchPublicRepo(userName: String) = withContext(Dispatchers.IO) {
        isBusy.set(true)
        userRepos.set(repository.getPublicRepo(userName))
        isBusy.set(false)
    }
}