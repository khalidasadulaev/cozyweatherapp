package com.example.cozyweatherapp.features.home.domain.models

data class HourlyWeatherModel(
    val date: Int,
    val main: MainModel,
    val weather: List<WeatherModel>
)