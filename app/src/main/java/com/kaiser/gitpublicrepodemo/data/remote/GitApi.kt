package com.kaiser.gitpublicrepodemo.data.remote

import okhttp3.OkHttpClient
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path

interface GitApi {

    @GET("{id}")
    suspend fun getSample(
        @Path("id") id: String
    ): Response<String>


    companion object {
        operator fun invoke(
            apiInterceptor: ApiInterceptor
        ): GitApi {
            val baseUrl = "https://dummy_base_url"
            val okkHttpclient = OkHttpClient.Builder()
                .addInterceptor(apiInterceptor)
                .build()

            return Retrofit.Builder()
                .client(okkHttpclient)
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(GitApi::class.java)
        }
    }
}