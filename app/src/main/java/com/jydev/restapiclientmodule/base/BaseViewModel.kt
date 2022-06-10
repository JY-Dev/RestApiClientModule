package com.jydev.restapiclientmodule.base

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.jydev.rest_api_util.model.NetworkResult
import com.jydev.restapiclientmodule.base.model.NetworkSideEffect
import com.jydev.restapiclientmodule.util.Event

open class BaseViewModel : ViewModel() {
    private val _networkSideEffect = MutableLiveData<Event<NetworkSideEffect>>()
    val networkSideEffect : LiveData<Event<NetworkSideEffect>>
        get() = _networkSideEffect
    fun <T> NetworkResult<T>.executeNetworkResult(
        title : String = "",
        success: (data: T) -> Unit,
        fail: ((message: String) -> Unit)? = null
    ) {
        when (this) {
            is NetworkResult.Success -> {
                Log.d("ExecuteNetworkResult","Success")
                success(data)
            }
            is NetworkResult.ServerFail -> {
                Log.d("ExecuteNetworkResult","ServerFail : $message")
                fail?.invoke(message) ?: kotlin.run {
                    _networkSideEffect.value = Event(NetworkSideEffect.ServerFail(message,title))
                }
            }
            is NetworkResult.ServerError -> {
                Log.d("ExecuteNetworkResult","ServerError : $message")
                _networkSideEffect.value = Event(NetworkSideEffect.ServerError(message,title))
            }
            is NetworkResult.Exception -> {
                Log.d("ExecuteNetworkResult","Exception : ${exception.message}")
                _networkSideEffect.value = Event(NetworkSideEffect.Exception(exception))
            }
            is NetworkResult.Idle -> {
                Log.d("ExecuteNetworkResult","Idle : $message")
            }
        }
    }
}