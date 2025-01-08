package com.example.cozyweatherapp.features.home.domain.models

data class WeatherModel(
    val description: String,
    val icon: String,
    val id: Int,
    val main: String
)