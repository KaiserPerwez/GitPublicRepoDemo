package com.kaiser.gitpublicrepodemo.data.remote

import com.kaiser.gitpublicrepodemo.data.model.UserDetails
import okhttp3.OkHttpClient
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path

interface GitHubApi {

    @GET("{user_name}")
    suspend fun fetchUserDetails(
        @Path("user_name") username: String
    ): Response<UserDetails>


    companion object {
        operator fun invoke(
            apiInterceptor: ApiInterceptor
        ): GitHubApi {
            val baseUrl = "https://api.github.com/users/"
            val okkHttpclient = OkHttpClient.Builder()
                .addInterceptor(apiInterceptor)
                .build()

            return Retrofit.Builder()
                .client(okkHttpclient)
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(GitHubApi::class.java)
        }
    }
}