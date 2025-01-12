package com.example.cozyweatherapp.features.home.presentation

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.cozyweatherapp.R
import com.example.cozyweatherapp.base.MyViewHolder
import com.example.cozyweatherapp.base.RetrofitInstance
import com.example.cozyweatherapp.features.home.data.repository.WeatherRepositoryImpl
import com.google.android.gms.location.FusedLocationProviderClient
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    private val viewModel by viewModels<MainPageViewModel>(factoryProducer = {
        object : ViewModelProvider.Factory {
            override fun <T : ViewModel> create(modelClass: Class<T>): T {
                return MainPageViewModel(WeatherRepositoryImpl(RetrofitInstance.api)) as T
            }
        }
    })

    private lateinit var fusedLocationClient: FusedLocationProviderClient

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        viewModel.getCurrentWeatherData(activity = this, context = this.baseContext)



        setContentView(R.layout.activity_main)
        val mainTemperature: TextView = findViewById(R.id.textView2)
        val mainWeather: TextView = findViewById(R.id.textView3)
        val city: TextView = findViewById(R.id.textView4)
        val feelsLike: TextView = findViewById(R.id.textView6)
        val sunSet: TextView = findViewById(R.id.textView7)
        val recyclerView: RecyclerView = findViewById(R.id.recyclerView)
        recyclerView.setLayoutManager(
            LinearLayoutManager(
                this,
                LinearLayoutManager.HORIZONTAL,
                false
            )
        )

//        ASKMENTOR: Не смог запустить два метода в одном launch. Как я оставил это ок?
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.CREATED) {
                viewModel.hourlyWeatherData.collectLatest { uiState ->
                    recyclerView.adapter = uiState?.list?.let { MyViewHolder(it) }
                }
            }
        }

        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.CREATED) {
                viewModel.weather.collectLatest { uiState ->
                    mainTemperature.text = "${uiState?.main?.temp.toString()}°"
                    mainWeather.text = uiState?.weather?.first()?.description
                    city.text = uiState?.name
                    feelsLike.text = uiState?.main?.feelsLike.toString()


                    if (uiState?.sys?.sunset != null) {
                        val sdf = java.text.SimpleDateFormat.getTimeInstance()
                        val time = uiState.sys.sunset.toLong()
                        val date = java.util.Date(time * 1000)

                        sunSet.text = sdf.format(date)
                    }
                }
            }
        }
    }
}