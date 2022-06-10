package com.jydev.restapiclientmodule.data.mapper

import com.jydev.restapiclientmodule.data.model.SampleDataResponse
import com.jydev.restapiclientmodule.domain.model.SampleData

fun SampleDataResponse.toDomain() : SampleData
    = SampleData(data)