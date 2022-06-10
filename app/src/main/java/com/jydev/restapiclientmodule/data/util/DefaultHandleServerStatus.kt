package com.jydev.restapiclientmodule.data.util

import com.jydev.rest_api_util.extension.HandleServerResult
import com.jydev.rest_api_util.extension.HandleServerStatus
import com.jydev.restapiclientmodule.data.model.Response
import com.jydev.restapiclientmodule.data.remote.SampleApi

class DefaultHandleServerStatus<T>(private val response: Response<T>) : HandleServerStatus {
    override fun isServerError(): HandleServerResult =
        HandleServerResult(response.message,response.status.not())

    override fun isServerFail(): HandleServerResult =
        HandleServerResult(response.message,response.code != SampleApi.SUCCESS_CODE)

    override fun isIdle(): HandleServerResult =
        HandleServerResult(response.message,response.code == SampleApi.IDLE_SERVER_CODE)

    override fun isTokenRefresh(): Boolean =
        JwtTokenRefresh.tokenStatus.not()


}