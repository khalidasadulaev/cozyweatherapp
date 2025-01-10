package com.example.cozyweatherapp.features.home.data.repository

import android.util.Log
import com.example.cozyweatherapp.features.home.data.datasource.remote.WeatherApi
import com.example.cozyweatherapp.features.home.data.entity.toModel
import com.example.cozyweatherapp.features.home.domain.models.TodayWeatherModel
import com.example.cozyweatherapp.features.home.domain.repository.IWeatherRepository

class WeatherRepositoryImpl(private val weatherAPI: WeatherApi) : IWeatherRepository {
    override suspend fun getCurrentWeatherData(
        apiKey: String,
        lat: Double,
        lon: Double,
    ): TodayWeatherModel? {

        return try {
            val result = weatherAPI.getCurrentWeatherData(
                apiKey = apiKey,
                lat = lat,
                lon = lon,
            )

            result.toModel()
        } catch (e: Throwable) {
            Log.d("tag", "Error: $e")

            null
        }
    }
}