package com.kaiser.gitpublicrepodemo.data.repository

import com.kaiser.gitpublicrepodemo.data.model.PublicRepoModel
import com.kaiser.gitpublicrepodemo.data.model.UserDetailsModel
import com.kaiser.gitpublicrepodemo.data.remote.ApiRequest

abstract class IGithubRepository: ApiRequest() {
    abstract suspend fun getUserDetails(userName: String): UserDetailsModel
    abstract suspend fun getPublicRepo(userName: String): List<PublicRepoModel>
}