package com.jydev.restapiclientmodule.domain.repository

import com.jydev.restapiclientmodule.domain.model.SampleData

interface SampleRepository {
    suspend fun getSampleData() : SampleData

    suspend fun getAnotherSampleData() : SampleData

    suspend fun getServerErrorData() : SampleData

    suspend fun getServerFailData() : SampleData

    suspend fun getIdleData() : SampleData
}