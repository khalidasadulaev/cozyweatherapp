package com.example.cozyweatherapp.features.home.data.entity

import com.example.cozyweatherapp.features.home.domain.models.CloudsModel
import com.example.cozyweatherapp.features.home.domain.models.CoordModel
import com.example.cozyweatherapp.features.home.domain.models.HourlyWeatherModel
import com.example.cozyweatherapp.features.home.domain.models.HourlyWeatherResponseModel
import com.example.cozyweatherapp.features.home.domain.models.MainModel
import com.example.cozyweatherapp.features.home.domain.models.RainModel
import com.example.cozyweatherapp.features.home.domain.models.SysModel
import com.example.cozyweatherapp.features.home.domain.models.TodayWeatherModel
import com.example.cozyweatherapp.features.home.domain.models.WeatherModel
import com.example.cozyweatherapp.features.home.domain.models.WindModel

fun CloudsEntity.toModel() = CloudsModel(
    all = all
)

fun CoordEntity.toModel() = CoordModel(
    lat = lat,
    lon = lon
)

fun HourlyWeatherEntity.toModel() = HourlyWeatherModel(
    date = dt,
    main = main.toModel(),
    weather = weather.map { it.toModel() }
)

fun HourlyWeatherResponseEntity.toModel() = HourlyWeatherResponseModel(
    cod = cod,
    message = message,
    count = cnt,
    list = list.map { it.toModel() }
)


fun MainEnity.toModel() = MainModel(
    feelsLike = feelsLike,
    grndLevel = grndLevel,
    humidity = humidity,
    pressure = pressure,
    seaLevel = seaLevel,
    temp = temp,
    tempMax = tempMax,
    tempMin = tempMin,
)

fun RainEntity.toModel() = RainModel(
    `1h` = `1h`
)

fun SysEntity.toModel() = SysModel(
    country = country,
    id = id,
    sunrise = sunrise,
    sunset = sunset,
    type = type
)

fun TodayWeatherEntity.toModel() = TodayWeatherModel(
    base = base,
    clouds = clouds.toModel(),
    cod = cod,
    coord = coord.toModel(),
    dt = dt,
    id = id,
    main = main.toModel(),
    name = name,
    rain = rain?.toModel(),
    sys = sys.toModel(),
    timezone = timezone,
    visibility = visibility,
    weather = weather.map { it.toModel() },
    wind = wind.toModel()
)

fun WeatherEntity.toModel() = WeatherModel(
    description = description,
    icon = icon,
    id = id,
    main = main
)


fun WindEntity.toModel() = WindModel(
    deg = deg,
    gust = gust,
    speed = speed
)