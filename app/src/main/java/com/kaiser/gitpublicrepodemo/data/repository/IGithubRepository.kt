package com.kaiser.gitpublicrepodemo.data.repository

import com.kaiser.gitpublicrepodemo.data.model.UserDetails
import com.kaiser.gitpublicrepodemo.data.remote.ApiRequest

abstract class IGithubRepository: ApiRequest() {
    abstract suspend fun getUserDetails(userName: String): UserDetails
}