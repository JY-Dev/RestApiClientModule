package com.jydev.restapiclientmodule.data.datasource

import com.jydev.restapiclientmodule.data.model.SampleDataResponse
import com.jydev.restapiclientmodule.data.remote.SampleApi
import com.jydev.restapiclientmodule.data.util.JwtTokenRefresh

class SampleDataSource(private val sampleApi: SampleApi) {
    suspend fun getSampleData() : SampleDataResponse =
        sampleApi.getSampleData().executeNetworkHandling(JwtTokenRefresh::refresh)

    suspend fun getAnotherSampleData() : SampleDataResponse =
        sampleApi.getAnotherSampleData().executeNetworkHandling(JwtTokenRefresh::refresh)

    suspend fun getServerErrorData() : SampleDataResponse =
        sampleApi.getServerErrorData().executeNetworkHandling(JwtTokenRefresh::refresh)

    suspend fun getServerFailData() : SampleDataResponse =
        sampleApi.getServerFailData().executeNetworkHandling(JwtTokenRefresh::refresh)

    suspend fun getIdleData() : SampleDataResponse =
        sampleApi.getIdleData().executeNetworkHandling(JwtTokenRefresh::refresh)
}