package com.example.locationmarker.data

import android.annotation.SuppressLint
import android.content.Context
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import com.google.android.gms.tasks.Task
import com.example.locationmarker.model.LocationModel

class LocationRepository(context: Context) {
    private val fusedLocationClient: FusedLocationProviderClient =
        LocationServices.getFusedLocationProviderClient(context)

    @SuppressLint("MissingPermission")
    fun getCurrentLocation(): Task<LocationModel> {
        return fusedLocationClient.lastLocation.continueWith { task ->
            val location = task.result
            LocationModel(location.latitude, location.longitude)
        }
    }
}
