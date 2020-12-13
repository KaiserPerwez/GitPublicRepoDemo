package com.kaiser.gitpublicrepodemo.data.remote

import com.kaiser.gitpublicrepodemo.utils.ApiException
import org.json.JSONException
import org.json.JSONObject
import retrofit2.Response

abstract class ApiRequest {

    suspend fun <T : Any> apiRequest(request: suspend () -> Response<T>): T {
        val response = request.invoke()
        if (response.isSuccessful) {
            return response.body()!!
        } else {
            val message = StringBuilder()
            response.errorBody()?.string()?.also { // data.toString returns json-objects, data.string() returns json-data
                try{
                    val jsonObject=JSONObject(it)
                    message.append(jsonObject.getString("message"))
                }catch(e: JSONException){
                    message.append(e.message?:"")
                }
            }
            message.append("\n Error Code: ${response.code()}")
            throw ApiException(message.toString())
        }

    }
}