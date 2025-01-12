package com.example.cozyweatherapp.base

object Constants {
    const val BASE_URL: String = "https://api.openweathermap.org";
    const val API_KEY: String = "bb562d0e4dddea9f0d96dbd5705e59c1";
}

enum class UnitsMeasurement(val jsonValue: String) {
    IMPERIAL(IMPERIAL.name.lowercase()), METRIC(METRIC.name.lowercase()), KELVIN(KELVIN.jsonValue.lowercase())
}