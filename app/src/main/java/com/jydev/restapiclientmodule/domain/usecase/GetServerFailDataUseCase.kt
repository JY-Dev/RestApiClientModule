package com.jydev.restapiclientmodule.domain.usecase

import com.jydev.rest_api_util.extension.executeChangeResult
import com.jydev.rest_api_util.model.NetworkResult
import com.jydev.restapiclientmodule.domain.model.SampleData
import com.jydev.restapiclientmodule.domain.repository.SampleRepository

class GetServerFailDataUseCase(private val sampleRepository: SampleRepository) {
    suspend operator fun invoke(): NetworkResult<SampleData> {
        return executeChangeResult {
            sampleRepository.getServerFailData()
        }
    }
}