package com.example.cozyweatherapp.features.home.presentation

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.cozyweatherapp.R
import com.example.cozyweatherapp.base.RetrofitInstance
import com.example.cozyweatherapp.features.home.data.repository.WeatherRepositoryImpl

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
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val mainGradus: TextView = findViewById(R.id.textView2)
        mainGradus.text = viewModel.weather.value?.main?.temp.toString()

    }
}