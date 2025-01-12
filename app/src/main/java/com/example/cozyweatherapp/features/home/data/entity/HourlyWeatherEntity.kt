package com.example.cozyweatherapp.features.home.data.entity

data class HourlyWeatherEntity(
    val dt: Int,
    val main: MainEnity,
    val weather: List<WeatherEntity>
)