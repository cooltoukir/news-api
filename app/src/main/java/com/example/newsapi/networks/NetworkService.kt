package com.example.newsapi.networks

import com.example.newsapi.models.TeslaModel
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Url

const val news_api_key = "291764f5411f455186b81e58ad437f39"
const val base_url = "https://newsapi.org/v2/"

// Retrofit objects for base url
val retrofit: Retrofit = Retrofit.Builder()
    .baseUrl(base_url)
    .addConverterFactory(GsonConverterFactory.create())
    .build()

// Interface for end url which use Suspend Function In Kotlin Coroutines
interface NewsServiceApi {

    // End url suspend function
    @GET
    suspend fun getTeslaNews(@Url endUrl : String) : TeslaModel
}

//Single tone pattern object to access interface and end url suspend function
object NetworkService {
    val newsServiceApi : NewsServiceApi by lazy {
        retrofit.create(NewsServiceApi::class.java)
    }
}
