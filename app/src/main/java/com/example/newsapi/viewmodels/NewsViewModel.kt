package com.example.newsapi.viewmodels

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.newsapi.models.TeslaModel
import com.example.newsapi.repos.NewsRepository
import kotlinx.coroutines.launch

// News API app ViewModel

class NewsViewModel : ViewModel(){

    private var alreadyFetchData = false

    private val repository = NewsRepository()

    val teslaLiveData : MutableLiveData<TeslaModel> = MutableLiveData()

    // Function for fetching data from repository

    fun fetchData() {

        // Check if data is already bing fetched. Fetched data only once

        if (!alreadyFetchData) {

            /* Use coroutine scope of ViewModel scope to call suspend
        function fetchTeslaData from repository
         */

            viewModelScope.launch {
                try {
                    teslaLiveData.value = repository.fetchTeslaData()
                } catch (e: Exception) {
                    e.localizedMessage?.let { Log.d("NewsViewModel", it) }
                }
            }
            alreadyFetchData = true
        }
    }
}
