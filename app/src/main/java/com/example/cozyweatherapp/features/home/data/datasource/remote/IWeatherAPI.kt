package com.example.cozyweatherapp.features.home.data.datasource.remote

import com.example.cozyweatherapp.features.home.domain.models.WeatherModel


interface IWeatherAPI {
    suspend fun getCurrentWeatherData(
        apiKey: String,
        lat: Double,
        lon: Double,
    ): WeatherModel
}