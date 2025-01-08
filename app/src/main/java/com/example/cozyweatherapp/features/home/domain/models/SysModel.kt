package com.example.cozyweatherapp.features.home.domain.models

data class SysModel(
    val country: String,
    val id: Int,
    val sunrise: Int,
    val sunset: Int,
    val type: Int
)