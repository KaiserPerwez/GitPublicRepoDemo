package com.kaiser.gitpublicrepodemo.data.repository

import com.kaiser.gitpublicrepodemo.data.model.UserDetails
import com.kaiser.gitpublicrepodemo.data.remote.GitHubApi

class GithubRepository(private val api: GitHubApi) : IGithubRepository() {
    override suspend fun getUserDetails(userName: String): UserDetails =
        apiRequest {
            api.fetchUserDetails(userName)
        }

}