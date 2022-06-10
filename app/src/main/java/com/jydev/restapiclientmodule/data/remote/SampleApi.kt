package com.jydev.restapiclientmodule.data.remote

import com.jydev.restapiclientmodule.data.model.Response
import com.jydev.restapiclientmodule.data.model.SampleDataResponse

class SampleApi {
    suspend fun getSampleData() : Response<SampleDataResponse>
        = Response(true,"E000","",SampleDataResponse("Sample"))

    suspend fun getAnotherSampleData() : Response<SampleDataResponse>
        = Response(true,"E000","",SampleDataResponse("Sample Another"))

    suspend fun getServerErrorData() : Response<SampleDataResponse>
        = Response(false,"E500","not exist",SampleDataResponse("Sample Another"))

    suspend fun getServerFailData() : Response<SampleDataResponse>
        = Response(true, "E369" , "Data is Empty" , SampleDataResponse("Sample"))

    suspend fun getIdleData() : Response<SampleDataResponse>
        = Response(true, IDLE_SERVER_CODE , "Idle" , SampleDataResponse("Sample"))

    companion object{
        const val IDLE_SERVER_CODE = "E333"
        const val SUCCESS_CODE = "E000"
        const val TOKEN_REFRESH_CODE = "E337"
    }
}