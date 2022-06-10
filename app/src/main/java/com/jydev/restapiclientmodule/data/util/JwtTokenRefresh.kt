package com.jydev.restapiclientmodule.data.util

import android.util.Log
import kotlinx.coroutines.delay

object JwtTokenRefresh {
    var tokenStatus = false
    suspend fun refresh(){
        Log.d("JwtToken","갱신중")
        delay(1000)
        tokenStatus = true
    }
}