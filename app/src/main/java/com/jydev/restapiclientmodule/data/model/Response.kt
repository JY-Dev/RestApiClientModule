package com.jydev.restapiclientmodule.data.model

import com.jydev.rest_api_util.extension.executeNetworkHandling
import com.jydev.restapiclientmodule.data.util.DefaultHandleServerStatus

data class Response<T>(
    val status: Boolean,
    val code: String,
    val message: String,
    val data: T
){
    suspend fun executeNetworkHandling(tokenRefresh: (suspend () -> Unit)? = null) : T{
        val handle = DefaultHandleServerStatus(this)
        return data.executeNetworkHandling(handle,tokenRefresh)
    }
}