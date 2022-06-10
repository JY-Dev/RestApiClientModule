package com.jydev.restapiclientmodule

import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.jydev.restapiclientmodule.base.BaseActivity
import com.jydev.restapiclientmodule.data.util.JwtTokenRefresh
import com.jydev.restapiclientmodule.databinding.ActivityMainBinding

class MainActivity : BaseActivity() {
    private lateinit var mainViewModel: MainViewModel
    private lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        mainViewModel = ViewModelProvider(this,MainViewModelFactory())[MainViewModel::class.java]
        observeData()
        binding.setListener()
    }

    private fun ActivityMainBinding.setListener(){
        getSampleDataButton.setOnClickListener{
            mainViewModel.getSampleData()
        }
        getMergeSampleDataButton.setOnClickListener{
            mainViewModel.getMergeSampleData()
        }
        serverErrorButton.setOnClickListener {
            mainViewModel.serverError()
        }
        serverFailButton.setOnClickListener {
            mainViewModel.serverFail()
        }
        idleButton.setOnClickListener {
            mainViewModel.idle()
        }
        tokenExpiredButton.setOnClickListener {
            JwtTokenRefresh.tokenStatus = false
        }
    }

    private fun observeData(){
        with(mainViewModel){
            observeNetworkSideEffect()
            sampleData.observe(this@MainActivity){
                Toast.makeText(this@MainActivity,"SampleData : "+it.data,Toast.LENGTH_LONG).show()
            }
            mergeSampleData.observe(this@MainActivity){
                Toast.makeText(this@MainActivity,"MergeSampleData : "+it.data,Toast.LENGTH_LONG).show()
            }
        }
    }
}