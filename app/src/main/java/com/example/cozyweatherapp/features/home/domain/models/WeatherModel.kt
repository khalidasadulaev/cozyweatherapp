package com.example.cozyweatherapp.features.home.domain.models
// TODO(MakeMeModel)
data class WeatherModel(
    val base: String,
    val clouds: CloudsModel,
    val cod: Int,
    val coord: Coord,
    val dt: Int,
    val id: Int,
    val main: MainModel,
    val name: String,
    val rain: RainModel,
    val sys: Sys,
    val timezone: Int,
    val visibility: Int,
    val weather: List<Weather>,
    val wind: Wind
)