package com.kaiser.gitpublicrepodemo.data.repository

import com.kaiser.gitpublicrepodemo.data.model.PublicRepoModel
import com.kaiser.gitpublicrepodemo.data.model.UserDetailsModel
import com.kaiser.gitpublicrepodemo.data.remote.GitHubApi

class GithubRepository(private val api: GitHubApi) : IGithubRepository() {
    override suspend fun getUserDetails(userName: String): UserDetailsModel =
        apiRequest {
            api.fetchUserDetails(userName)
        }

    override suspend fun getPublicRepo(userName: String): List<PublicRepoModel> =
    apiRequest {
        api.getPublicRepos(userName)
    }

}