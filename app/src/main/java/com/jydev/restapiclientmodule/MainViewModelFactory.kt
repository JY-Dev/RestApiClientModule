package com.jydev.restapiclientmodule

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.jydev.restapiclientmodule.data.datasource.SampleDataSource
import com.jydev.restapiclientmodule.data.remote.SampleApi
import com.jydev.restapiclientmodule.data.repository.SampleRepositoryImpl
import com.jydev.restapiclientmodule.domain.usecase.*

class MainViewModelFactory : ViewModelProvider.Factory {
    private val sampleApi = SampleApi()
    private val sampleDataSource = SampleDataSource(sampleApi)
    private val sampleRepository = SampleRepositoryImpl(sampleDataSource)
    private val getSampleDataUseCase = GetSampleDataUseCase(sampleRepository)
    private val getMergeSampleDataUseCase = GetMergeSampleDataUseCase(sampleRepository)
    private val getIdleDataUseCase = GetIdleDataUseCase(sampleRepository)
    private val getServerErrorDataUseCase = GetServerErrorDataUseCase(sampleRepository)
    private val getServerFailDataUseCase = GetServerFailDataUseCase(sampleRepository)
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return if (modelClass.isAssignableFrom(MainViewModel::class.java)) {
            MainViewModel(
                getSampleDataUseCase,
                getMergeSampleDataUseCase,
                getIdleDataUseCase,
                getServerErrorDataUseCase,
                getServerFailDataUseCase
            ) as T
        } else {
            throw IllegalArgumentException()
        }
    }
}