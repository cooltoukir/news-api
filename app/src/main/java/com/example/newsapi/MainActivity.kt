package com.example.newsapi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.example.newsapi.viewmodels.NewsViewModel

class MainActivity : AppCompatActivity() {
    private val newsViewModel : NewsViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        receiveDataFromVM()
    }

    // Receive data from ViewModel
    private fun receiveDataFromVM() {
        newsViewModel.fetchData()
    }
}
