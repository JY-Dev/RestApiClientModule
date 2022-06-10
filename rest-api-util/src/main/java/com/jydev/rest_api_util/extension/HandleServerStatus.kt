package com.jydev.rest_api_util.extension

interface HandleServerStatus {
    fun isServerError() : HandleServerResult
    fun isServerFail() : HandleServerResult
    fun isIdle() : HandleServerResult
    fun isTokenRefresh() : Boolean
}

data class HandleServerResult(val message : String, val status : Boolean)