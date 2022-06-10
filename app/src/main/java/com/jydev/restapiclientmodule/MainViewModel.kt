package com.jydev.restapiclientmodule

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.jydev.restapiclientmodule.base.BaseViewModel
import com.jydev.restapiclientmodule.domain.model.MergeSampleData
import com.jydev.restapiclientmodule.domain.model.SampleData
import com.jydev.restapiclientmodule.domain.usecase.*
import kotlinx.coroutines.launch

class MainViewModel(
    private val getSampleDataUseCase: GetSampleDataUseCase,
    private val getMergeSampleDataUseCase: GetMergeSampleDataUseCase,
    private val getIdleDataUseCase: GetIdleDataUseCase,
    private val getServerErrorDataUseCase: GetServerErrorDataUseCase,
    private val getServerFailDataUseCase: GetServerFailDataUseCase,
) : BaseViewModel(){
    private val _sampleData = MutableLiveData<SampleData>()
    val sampleData : LiveData<SampleData>
        get() = _sampleData

    private val _mergeSampleData = MutableLiveData<MergeSampleData>()
    val mergeSampleData : LiveData<MergeSampleData>
        get() = _mergeSampleData
    fun serverError(){
        viewModelScope.launch {
            getServerErrorDataUseCase().executeNetworkResult("",{
                _sampleData.value = it
            })

        }
    }

    fun idle(){
        viewModelScope.launch {
            getIdleDataUseCase().executeNetworkResult("",{
                _sampleData.value = it
            })
        }
    }

    fun serverFail(){
        viewModelScope.launch {
            getServerFailDataUseCase().executeNetworkResult("",{
                _sampleData.value = it
            })
        }
    }

    fun getMergeSampleData(){
        viewModelScope.launch {
            getMergeSampleDataUseCase().executeNetworkResult("",{
                _mergeSampleData.value = it
            })
        }
    }

    fun getSampleData(){
        viewModelScope.launch {
            getSampleDataUseCase().executeNetworkResult("",{
                _sampleData.value = it
            })
        }
    }
}