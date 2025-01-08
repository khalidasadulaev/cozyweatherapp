package com.example.cozyweatherapp.features.home.data.repository

import com.example.cozyweatherapp.features.home.data.datasource.remote.IWeatherAPI
import com.example.cozyweatherapp.features.home.domain.models.WeatherModel
import com.example.cozyweatherapp.features.home.domain.repository.IWeatherRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class WeatherRepositoryImpl(private val weatherAPI: IWeatherAPI) : IWeatherRepository {
    override suspend fun getCurrentWeatherData(
        apiKey: String,
        lat: Double,
        lon: Double,
        ): Flow<WeatherModel?> {
        return flow {
            val todayWeatherData = try {
                weatherAPI.getCurrentWeatherData(
                    apiKey = apiKey,
                    lat = lat,
                    lon = lon,
                );
            } catch (e: Throwable) {
                println(e)
                return@flow
            }
            emit(todayWeatherData)
        }

    }
}