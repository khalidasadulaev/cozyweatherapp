package com.example.cozyweatherapp.features.home.data.datasource.remote

import com.example.cozyweatherapp.features.home.domain.models.WeatherModel
import retrofit2.http.GET
import retrofit2.http.Query


class RemoteWeatherImpl : IWeatherAPI {
    @GET("data/2.5/weather?lat={lat}&lon={lon}&")
    override suspend fun getCurrentWeatherData(
        @Query("appId") apiKey: String,
        @Query("lat") lat: Double,
        @Query("lon") lon: Double,
    ): WeatherModel {
        TODO()
    }
}