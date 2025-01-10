package com.example.cozyweatherapp.base

import android.content.Context
import android.health.connect.datatypes.ExerciseRoute
import android.location.LocationManager
import com.google.android.gms.location.FusedLocationProviderClient
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow

class LocationClientImpl(
    private val context: Context,
    private val client: FusedLocationProviderClient
) : LocationClient {
    override fun getLocationUpdates(interval: Long): Flow<ExerciseRoute.Location> {
        return callbackFlow {
            if (!context.hasLocationPermission()) {
                throw LocationClient.LocationException("Location permission is not granted")
            }

            val locationManager =
                context.getSystemService(Context.LOCATION_SERVICE) as LocationManager
            val isGpsEnabled = locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER)
            val isNetworkEnabled =
                locationManager.isProviderEnabled(LocationManager.NETWORK_PROVIDER)
            if (!isGpsEnabled && !isNetworkEnabled) {
                throw LocationClient.LocationException("GPS is disabled")
            }
        }
    }
}