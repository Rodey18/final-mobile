package com.D121211077.kapanMatahari.ui.activities.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.D121211077.kapanMatahari.data.repository.TimeRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class TimeViewModel(private val repository: TimeRepository) : ViewModel() {

    private val _sunriseTime = MutableStateFlow<String?>(null)
    val sunriseTime: StateFlow<String?> = _sunriseTime

    private val _sunsetTime = MutableStateFlow<String?>(null)
    val sunsetTime: StateFlow<String?> = _sunsetTime

    fun getTime(lat: String, lng: String) {
        viewModelScope.launch {
            val response = repository.getTime(lat, lng)
            _sunriseTime.value = response.results?.sunrise
            _sunsetTime.value = response.results?.sunset
        }
    }
}
