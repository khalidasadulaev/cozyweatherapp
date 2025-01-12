package com.example.cozyweatherapp.features.home.data.datasource.remote

import com.example.cozyweatherapp.base.UnitsMeasurement
import com.example.cozyweatherapp.features.home.data.entity.HourlyWeatherResponseEntity
import com.example.cozyweatherapp.features.home.data.entity.TodayWeatherEntity
import retrofit2.http.GET
import retrofit2.http.Query


interface WeatherApi {
    @GET("data/2.5/weather")
    suspend fun getCurrentWeatherData(
        @Query("appId") apiKey: String,
        @Query("lat") lat: Double,
        @Query("lon") lon: Double,
        @Query("units") units: String = "imperial"
    ): TodayWeatherEntity

    @GET("data/2.5/forecast")
    suspend fun getHourlyWeatherDate(
        @Query("appId") apiKey: String,
        @Query("lat") lat: Double,
        @Query("lon") lon: Double,
        @Query("cnt") count: Int,
        @Query("units") units: String = "imperial"
    ): HourlyWeatherResponseEntity
}