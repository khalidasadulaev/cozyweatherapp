package com.example.cozyweatherapp.base

import android.health.connect.datatypes.ExerciseRoute.Location
import kotlinx.coroutines.flow.Flow

interface LocationClient {
    fun  getLocationUpdates(interval: Long): Flow<Location>

    class LocationException(message: String) : Exception()
}