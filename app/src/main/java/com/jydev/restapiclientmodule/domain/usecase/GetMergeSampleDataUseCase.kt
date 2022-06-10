package com.jydev.restapiclientmodule.domain.usecase

import com.jydev.rest_api_util.extension.executeChangeResult
import com.jydev.rest_api_util.model.NetworkResult
import com.jydev.restapiclientmodule.domain.model.MergeSampleData
import com.jydev.restapiclientmodule.domain.model.SampleData
import com.jydev.restapiclientmodule.domain.repository.SampleRepository

class GetMergeSampleDataUseCase(private val sampleRepository: SampleRepository) {
    suspend operator fun invoke(): NetworkResult<MergeSampleData> {
        return executeChangeResult {
            val data = sampleRepository.getSampleData()
            val anotherData = sampleRepository.getAnotherSampleData()
            MergeSampleData(data.data + "_" + anotherData.data)
        }
    }
}