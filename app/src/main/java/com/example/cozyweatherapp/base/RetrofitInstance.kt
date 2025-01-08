package com.example.cozyweatherapp.base

import com.example.cozyweatherapp.features.home.data.datasource.remote.IWeatherAPI
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {
//    private val interceptor: HttpLoggingInterceptor = HttpLoggingInterceptor).apply {
//     level = HttpLoggingInterceptor.Level.BODY
//     ｝

    private val client: OkHttpClient = OkHttpClient.Builder()
        .build()

    val api: IWeatherAPI = Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl(Constants.BASE_URL)
        .client(client).build()
        .create(
            IWeatherAPI::
            class.java
        )

}