package com.example.cozyweatherapp.features.home.domain.models

data class TodayWeatherModel(
    val base: String,
    val clouds: CloudsModel,
    val cod: Int,
    val coord: CoordModel,
    val dt: Int,
    val id: Int,
    val main: MainModel,
    val name: String,
    val rain: RainModel,
    val sys: SysModel,
    val timezone: Int,
    val visibility: Int,
    val weather: List<WeatherModel>,
    val wind: WindModel
)