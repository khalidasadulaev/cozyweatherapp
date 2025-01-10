package com.example.cozyweatherapp.features.home.data.datasource.remote

import com.example.cozyweatherapp.features.home.data.entity.TodayWeatherEntity
import retrofit2.http.GET
import retrofit2.http.Query


interface WeatherApi {
    @GET("data/2.5/weather")
    suspend fun getCurrentWeatherData(
        @Query("appId") apiKey: String,
        @Query("lat") lat: Double,
        @Query("lon") lon: Double,
    ): TodayWeatherEntity
}