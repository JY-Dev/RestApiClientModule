package com.jydev.restapiclientmodule.data.repository

import com.jydev.restapiclientmodule.data.datasource.SampleDataSource
import com.jydev.restapiclientmodule.data.mapper.toDomain
import com.jydev.restapiclientmodule.domain.repository.SampleRepository
import com.jydev.restapiclientmodule.domain.model.SampleData

class SampleRepositoryImpl(private val sampleDataSource: SampleDataSource) : SampleRepository {
    override suspend fun getSampleData(): SampleData =
        sampleDataSource.getSampleData().toDomain()

    override suspend fun getAnotherSampleData(): SampleData =
        sampleDataSource.getAnotherSampleData().toDomain()

    override suspend fun getServerErrorData(): SampleData =
        sampleDataSource.getServerErrorData().toDomain()

    override suspend fun getServerFailData(): SampleData =
        sampleDataSource.getServerFailData().toDomain()

    override suspend fun getIdleData(): SampleData =
        sampleDataSource.getIdleData().toDomain()
}