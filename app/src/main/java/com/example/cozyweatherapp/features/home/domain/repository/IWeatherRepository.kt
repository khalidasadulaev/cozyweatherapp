package com.example.cozyweatherapp.features.home.domain.repository

import com.example.cozyweatherapp.features.home.domain.models.HourlyWeatherResponseModel
import com.example.cozyweatherapp.features.home.domain.models.TodayWeatherModel

interface IWeatherRepository {

    suspend fun getCurrentWeatherData(
        apiKey: String,
        lat: Double,
        lon: Double,
    ):  TodayWeatherModel?

    suspend fun getHourlyWeatherDate(
        apiKey: String,
        lat: Double,
        lon: Double,
        count: Int,
    ): HourlyWeatherResponseModel?

}