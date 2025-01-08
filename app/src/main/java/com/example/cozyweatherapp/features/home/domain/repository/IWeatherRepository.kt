package com.example.cozyweatherapp.features.home.domain.repository

import com.example.cozyweatherapp.features.home.domain.models.WeatherModel
import kotlinx.coroutines.flow.Flow

interface IWeatherRepository {
    suspend fun getCurrentWeatherData(
        apiKey: String,
        lat: Double,
        lon: Double,
    ): Flow<WeatherModel?>
}