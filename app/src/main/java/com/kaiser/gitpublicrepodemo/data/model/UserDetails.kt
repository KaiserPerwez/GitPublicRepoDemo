package com.kaiser.gitpublicrepodemo.data.model

import com.google.gson.annotations.SerializedName

data class UserDetails (
    @SerializedName("avatar_url")
    val avatarUrl: String?,
    val bio: String?,
    val blog: String?,
    val company: String?,
    @SerializedName("created_at")
    val userSince: String?,
    val email: String?,
    val followers: Int?,
    val following: Int?,
    val hireable: Boolean?,
    @SerializedName("html_url")
    val gitPageUrl: String?,
    val id: Int?,
    val location: String?,
    @SerializedName("login")
    val username: String?,
    val name: String?,
   @SerializedName("public_gists")
    val gists: Int?,
    @SerializedName("public_repos")
    val repos: Int?,
    @SerializedName("repos_url")
    val reposUrl: String?,
    @SerializedName("site_admin")
    val siteAdmin: Boolean?,
    @SerializedName("twitter_username")
    val twitterUsername: String?,
    val type: String?,
    @SerializedName("updated_at")
    val updatedAt: String
)