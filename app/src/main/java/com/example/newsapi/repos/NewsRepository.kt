package com.example.newsapi.repos

import com.example.newsapi.models.TeslaModel
import com.example.newsapi.networks.NetworkService
import com.example.newsapi.networks.news_api_key

// Repository class for fetching data from api

class NewsRepository {

    // Suspend function to fetch data from suspend fun getTeslaNews

    suspend fun fetchTeslaData(): TeslaModel {

        val endUrl = "everything?q=tesla&from=2022-10-03&sortBy=publishedAt&apiKey=$news_api_key"

        /* Returning (which type is data class TeslaModel)
        by accessing NetworkService object to access getTeslaNews function
         */

        return NetworkService.newsServiceApi
            .getTeslaNews(endUrl)
    }
}
