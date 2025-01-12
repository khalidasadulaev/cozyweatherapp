package com.example.cozyweatherapp.features.home.data.entity

data class HourlyWeatherResponseEntity(
    val cod: Int,
    val message: Int,
    val cnt: Int,
    val list: List<HourlyWeatherEntity>
)