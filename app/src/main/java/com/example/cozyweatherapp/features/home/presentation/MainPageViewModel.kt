package com.example.cozyweatherapp.features.home.presentation

import android.Manifest
import android.annotation.SuppressLint
import android.content.Context
import android.util.Log
import androidx.core.app.ActivityCompat
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cozyweatherapp.base.Constants
import com.example.cozyweatherapp.base.extensions.hasLocationPermission
import com.example.cozyweatherapp.features.home.domain.models.HourlyWeatherResponseModel
import com.example.cozyweatherapp.features.home.domain.models.TodayWeatherModel
import com.example.cozyweatherapp.features.home.domain.repository.IWeatherRepository
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch

class MainPageViewModel(
    private val weatherRepository: IWeatherRepository
) : ViewModel() {

    private val _todayWeather = MutableStateFlow<TodayWeatherModel?>(null)
    val weather = _todayWeather.asStateFlow()

    private val _hourlyWeatherData = MutableStateFlow<HourlyWeatherResponseModel?>(null)
    val hourlyWeatherData = _hourlyWeatherData.asStateFlow()

    private val _showErrorToastChannel = Channel<Boolean>()
    val showErrorToastChannel = _showErrorToastChannel.receiveAsFlow()

    @SuppressLint("MissingPermission")
    fun getCurrentWeatherData(activity: MainActivity, context: Context) {
        var lat: Double = 42.966633
        var lon: Double = 47.512630

        ActivityCompat.requestPermissions(
            activity,
            arrayOf(
                Manifest.permission.ACCESS_COARSE_LOCATION,
                Manifest.permission.ACCESS_FINE_LOCATION,
            ),
            0
        )

        if (!context.hasLocationPermission()) {
            throw Exception()
        } else {

            val task = LocationServices.getFusedLocationProviderClient(activity).lastLocation

            task.addOnSuccessListener { location ->
                lat = location.latitude
                lon = location.longitude

                Log.d("tag", "Successfully got location data: $location")

                viewModelScope.launch {
                    val todayWeather = weatherRepository.getCurrentWeatherData(
                        apiKey = Constants.API_KEY,
                        lat = lat,
                        lon = lon,
                    )
                    _todayWeather.emit(todayWeather)

                    val hourlyWeatherData = weatherRepository.getHourlyWeatherDate(
                        apiKey = Constants.API_KEY,
                        lat = lat,
                        lon = lon,
                        count = 7
                    )
                    _hourlyWeatherData.emit(hourlyWeatherData)
                }

            }

        }

    }

}

