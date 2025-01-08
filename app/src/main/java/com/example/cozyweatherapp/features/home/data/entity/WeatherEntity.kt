package com.example.cozyweatherapp.features.home.data.entity

data class WeatherEntity(
    val base: String,
    val clouds: CloudsEntity,
    val cod: Int,
    val coord: CoordEntity,
    val dt: Int,
    val id: Int,
    val main: MainEnity,
    val name: String,
    val rain: RainEnity,
    val sys: SysEntity,
    val timezone: Int,
    val visibility: Int,
    val weather: List<WeatherEnt>,
    val wind: WindEntity
)