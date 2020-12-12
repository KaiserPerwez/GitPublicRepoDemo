package com.kaiser.gitpublicrepodemo.data.remote

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import com.kaiser.gitpublicrepodemo.utils.NoInternetException
import okhttp3.Interceptor
import okhttp3.Response

class ApiInterceptor(
    context: Context
) : Interceptor {

    private val applicationContext = context.applicationContext

    override fun intercept(chain: Interceptor.Chain): Response {
        if (!isInternetAvailable())
            throw NoInternetException("Oops!!, It seems your internet connection broke.")
        return chain.proceed(chain.request())
    }

    private fun isInternetAvailable(): Boolean {
        var result = false
        val connectivityManager =
            applicationContext.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager?

        connectivityManager?.getNetworkCapabilities(connectivityManager.activeNetwork)?.apply {
            result =
                hasTransport(NetworkCapabilities.TRANSPORT_WIFI) || hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR)

        }
        return result
    }

}