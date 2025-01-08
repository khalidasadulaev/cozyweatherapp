package com.example.cozyweatherapp.features.home.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cozyweatherapp.base.Constants
import com.example.cozyweatherapp.features.home.domain.models.WeatherModel
import com.example.cozyweatherapp.features.home.domain.repository.IWeatherRepository
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class MainPageViewModel(
    private val weatherRepository: IWeatherRepository
) : ViewModel() {


    private val _todayWeather = MutableStateFlow<WeatherModel?>(null)
    val weather = _todayWeather.asStateFlow()

    private val _showErrorToastChannel = Channel<Boolean>()
    val showErrorToastChannel = _showErrorToastChannel.receiveAsFlow()

    init {
        viewModelScope.launch {
            weatherRepository.getCurrentWeatherData(
                apiKey = Constants.API_KEY,
                lat = 42.966633,
                lon = 47.512630,
            ).collectLatest { result ->
                println("Initialized. Result -> $result")

                when (result) {
                    null -> _showErrorToastChannel.send(true)
                    else -> result.let {
                        _todayWeather.update { it }
                    }
                }


            }
        }
    }

}