package com.jydev.rest_api_util.model

sealed class NetworkResult<out DATA>{
    data class ServerError(val message : String) : NetworkResult<Nothing>()
    data class ServerFail(val message : String) : NetworkResult<Nothing>()
    data class Success<DATA>(val data : DATA) : NetworkResult<DATA>()
    data class Exception(val exception: java.lang.Exception) : NetworkResult<Nothing>()
    data class Idle(val message: String) : NetworkResult<Nothing>()
}
