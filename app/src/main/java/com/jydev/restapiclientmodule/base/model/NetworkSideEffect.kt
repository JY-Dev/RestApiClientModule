package com.jydev.restapiclientmodule.base.model

sealed class NetworkSideEffect{
    data class ServerError(val message : String, val title : String) : NetworkSideEffect()
    data class ServerFail(val message : String, val title : String) : NetworkSideEffect()
    data class Exception(val exception: java.lang.Exception) : NetworkSideEffect()
}
