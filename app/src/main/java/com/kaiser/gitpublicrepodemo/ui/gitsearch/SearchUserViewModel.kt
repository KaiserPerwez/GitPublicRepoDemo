package com.kaiser.gitpublicrepodemo.ui.gitsearch

import androidx.databinding.ObservableField
import androidx.lifecycle.ViewModel
import com.kaiser.gitpublicrepodemo.data.model.UserDetails
import com.kaiser.gitpublicrepodemo.data.repository.IGithubRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class SearchUserViewModel(private val repository: IGithubRepository) : ViewModel() {

    val userDetails = ObservableField<UserDetails>()
    val isBusy = ObservableField<Boolean>()

    suspend fun fetchUserDetails(userName: String) = withContext(Dispatchers.IO) {
        isBusy.set(true)
        userDetails.set(repository.getUserDetails(userName))
        isBusy.set(false)
    }
}

