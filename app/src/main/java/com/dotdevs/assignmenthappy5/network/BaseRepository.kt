package com.dotdevs.assignmenthappy5.network

import retrofit2.Response
import timber.log.Timber
import java.io.IOException

open class BaseRepository {

    suspend fun <T: Any> apiCall(call: suspend () -> Response<T>, errorMessage: String) :T? {

        val result: Result<T> = apiResult(call, errorMessage)
        var data: T? = null

        when(result) {
            is Result.Success -> data = result.data
            is Result.Error -> {
                Timber.d(errorMessage)
                Timber.e(result.exception)
            }
        }

        return data

    }

    private suspend fun <T : Any> apiResult(call : suspend() -> Response<T>, errorMessage: String): Result<T> {
        val response = call.invoke()
        if (response.isSuccessful) return Result.Success(response.body()!!)

        return Result.Error(
            IOException(
                "Error occured during getting api result, message => $errorMessage"
            )
        )
    }

}