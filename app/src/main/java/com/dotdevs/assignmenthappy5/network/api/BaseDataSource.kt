package com.dotdevs.assignmenthappy5.network.api

import com.dotdevs.assignmenthappy5.utils.Resource
import retrofit2.Response
import timber.log.Timber

abstract class BaseDataSource {

    protected suspend fun <T> getResult(call: suspend () -> Response<T>): Resource<T> {
        try {
            val response = call()

            if (response.isSuccessful) {
               if (response.body() != null) return Resource.success(response.body()!!)
            }

            return error("${response.code()} ${response.message()}")
        } catch (e: Exception) {
            return error(e.message ?: e.toString())
        }
    }

    private fun <T> error(message: String): Resource<T> {
        Timber.d(message)

        return Resource.error(
            null,
            "Network call failed for following reason: $message"
        )
    }

}