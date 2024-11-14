package com.example.locationmarker.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.locationmarker.data.LocationRepository
import com.example.locationmarker.model.LocationModel

class LocationViewModel(application: Application) : AndroidViewModel(application) {
    private val repository = LocationRepository(application)
    private val _location = MutableLiveData<LocationModel>()
    val location: LiveData<LocationModel> get() = _location

    fun fetchCurrentLocation() {
        repository.getCurrentLocation().addOnSuccessListener {
            _location.postValue(it)
        }
    }
}
