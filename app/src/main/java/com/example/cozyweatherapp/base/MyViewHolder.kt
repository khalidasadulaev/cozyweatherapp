package com.example.cozyweatherapp.base

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.cozyweatherapp.R
import com.example.cozyweatherapp.features.home.domain.models.HourlyWeatherModel

class MyViewHolder(private val hourlyWeatherData: List<HourlyWeatherModel>) :
    RecyclerView.Adapter<MyViewHolder.ViewHolder>() {


    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val temp: TextView
        val hourlyWeatherHour: TextView

        init {
            temp = view.findViewById(R.id.hourlyWeatherTemp)
            hourlyWeatherHour = view.findViewById(R.id.hourlyWeatherHour)

        }
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.recycle_layout, viewGroup, false)

        return ViewHolder(view)

    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        viewHolder.temp.text = hourlyWeatherData[position].main.temp.toString() + "°"
        // ASKMENTOR: Как нормально работать с форматом даты?
        val sdf = java.text.SimpleDateFormat.getTimeInstance()
        val time = hourlyWeatherData[position].date.toLong()
        val date = java.util.Date(time * 1000)
        Log.d("date", sdf.format(date).count().toString())


        viewHolder.hourlyWeatherHour.text = sdf.format(date).let { it ->
            if (it.count() == 10) it.substring(0..3) else it.substring(0..4)
        }
    }

    override fun getItemCount() = hourlyWeatherData.size

}