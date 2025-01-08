package com.example.cozyweatherapp.features.home.data.datasource.remote

import com.example.cozyweatherapp.features.home.data.entity.TodayWeatherEntity
import com.example.cozyweatherapp.features.home.domain.models.TodayWeatherModel
import retrofit2.http.GET
import retrofit2.http.Query


interface WeatherApi {
    @GET("data/2.5/weather")
    suspend fun getCurrentWeatherData(
        @Query("appId") apiKey: String,
        @Query("lat") lat: Double,
        @Query("lon") lon: Double,
        // TODO(kasadulaev): Make it TodayWeatherEntity after writing mappers
    ): TodayWeatherModel
}