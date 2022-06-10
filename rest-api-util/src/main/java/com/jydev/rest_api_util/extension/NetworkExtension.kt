package com.jydev.rest_api_util.extension

import com.jydev.rest_api_util.exception.IdleException
import com.jydev.rest_api_util.exception.ServerErrorException
import com.jydev.rest_api_util.exception.ServerFailException
import com.jydev.rest_api_util.model.NetworkResult

suspend fun <DATA> DATA.executeNetworkHandling(
    handleServerStatus: HandleServerStatus? = null,
    tokenRefresh: (suspend () -> Unit)? = null
): DATA {
    handleServerStatus?.let {
        val idleResult = handleServerStatus.isIdle()
        val serverErrorResult = handleServerStatus.isServerError()
        val serverFailResult = handleServerStatus.isServerFail()
        val isTokenRefresh = handleServerStatus.isTokenRefresh() && tokenRefresh != null
        return when {
            isTokenRefresh -> {
                tokenRefresh?.invoke()
                executeNetworkHandling(handleServerStatus, tokenRefresh)
            }
            idleResult.status -> {
                throw IdleException(idleResult.message)
            }
            serverErrorResult.status -> {
                throw ServerErrorException(serverErrorResult.message)
            }
            serverFailResult.status -> {
                throw ServerFailException(serverFailResult.message)
            }
            else -> this
        }
    }?: kotlin.run {
        return this
    }
}

suspend fun <DATA> executeChangeResult(getData: suspend () -> DATA): NetworkResult<DATA> {
    return try {
        val data = getData()
        NetworkResult.Success(data)
    } catch (e: Exception) {
        when (e) {
            is IdleException -> NetworkResult.Idle(e.message)
            is ServerErrorException -> NetworkResult.ServerError(e.message)
            is ServerFailException -> NetworkResult.ServerFail(e.message)
            else -> NetworkResult.Exception(e)
        }
    }
}
