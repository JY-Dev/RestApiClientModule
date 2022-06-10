package com.jydev.restapiclientmodule.base

import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.jydev.restapiclientmodule.base.model.NetworkSideEffect

open class BaseActivity : AppCompatActivity() {

    fun BaseViewModel.observeNetworkSideEffect(){
        networkSideEffect.observe(this@BaseActivity){
            it.getContentIfNotHandled()?.let {
                val message = when(it){
                    is NetworkSideEffect.Exception -> {
                        "Exception : ${it.exception.message}"
                    }
                    is NetworkSideEffect.ServerError -> {
                        "ServerError : ${it.message}"
                    }
                    is NetworkSideEffect.ServerFail -> {
                        "ServerFail : ${it.message}"
                    }
                }
                Toast.makeText(this@BaseActivity,message,Toast.LENGTH_LONG).show()
            }
        }
    }
}