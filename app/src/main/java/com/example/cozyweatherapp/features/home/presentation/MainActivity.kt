package com.example.cozyweatherapp.features.home.presentation

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.example.cozyweatherapp.R
import com.example.cozyweatherapp.base.RetrofitInstance
import com.example.cozyweatherapp.features.home.data.repository.WeatherRepositoryImpl
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    private val viewModel by viewModels<MainPageViewModel>(factoryProducer = {
        object : ViewModelProvider.Factory {
            override fun <T : ViewModel> create(modelClass: Class<T>): T {
                return MainPageViewModel(WeatherRepositoryImpl(RetrofitInstance.api)) as T
            }
        }
    });

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val mainTemperature: TextView = findViewById(R.id.textView2)
        val mainWeather: TextView = findViewById(R.id.textView3)
        val city: TextView = findViewById(R.id.textView4)

        lifecycleScope.launch {

            repeatOnLifecycle(Lifecycle.State.CREATED) {

                viewModel.weather.collectLatest { uiState ->
                    Log.d("tag", "Initialized result : $uiState")

                    mainTemperature.text = "${uiState?.main?.temp.toString()}°"
                    mainWeather.text = uiState?.weather?.first()?.description
                    city.text = uiState?.name
                }
            }
        }
    }
}