package com.D121211077.kapanMatahari.ui.activities.main

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.D121211077.kapanMatahari.MyApplication
import com.D121211077.kapanMatahari.data.models.SunInfo
import com.D121211077.kapanMatahari.data.repository.TimeRepository
import kotlinx.coroutines.launch
import java.io.IOException

sealed interface MainUiState {
    data class Success(val time: SunInfo) : MainUiState
    object Error : MainUiState
    object Loading : MainUiState
}

class MainViewModel(private val timeRepository: TimeRepository): ViewModel() {

    var mainUiState: MainUiState by mutableStateOf(MainUiState.Loading)
        private set

    private fun getTime() = viewModelScope.launch {
        mainUiState = MainUiState.Loading
        try {
            val result = timeRepository.getTime(
                lat = "36.7201600",
                lng = "-4.4203400"
            )
            mainUiState = MainUiState.Success(result.results)
            Log.d("MainViewMode", "getTime success: ${result.results}")
        } catch (e: IOException) {
            Log.d("MainViewMode", "getTime error: ${e.message}")
            mainUiState = MainUiState.Error
        }
    }

    init {
        getTime()
    }

    companion object {
        val Factory: ViewModelProvider.Factory = viewModelFactory {
            initializer {
                val application = (this[APPLICATION_KEY] as MyApplication)
                val timeRepository = application.container.timeRepository
                MainViewModel(timeRepository)
            }
        }
    }

}