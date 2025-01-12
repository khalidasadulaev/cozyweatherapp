package com.example.cozyweatherapp.features.home.domain.models

data class HourlyWeatherResponseModel(
    val cod: Int,
    val message: Int,
    val count: Int,
    val list: List<HourlyWeatherModel>
)