package com.codebay.kotlinapi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log



import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.codebay.kotlinapi.databinding.ActivityMainBinding
import com.codebay.kotlinapi.repository.Repository





class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)



        val repository = Repository()
        val viewModelFactory = MainViewModelFactory(repository)
        viewModel = ViewModelProvider(this,viewModelFactory).get(MainViewModel::class.java)
        viewModel.getPost()
        viewModel.myResponse.observe(this, Observer {response ->

            if(response.isSuccessful){
                Log.d("Response ",response.body()?.userId.toString())
                Log.d("Response ",response.body()?.id.toString())
                Log.d("Response",response.body()?.title!!)
                Log.d("Response ",response.body()?.body!!)
                binding.mes.text = response.body()?.title!!

            }else{
                Log.d("Response",response.errorBody().toString())
                binding.mes.text = "Sunucu Hatası"
            }

        })
    }
}