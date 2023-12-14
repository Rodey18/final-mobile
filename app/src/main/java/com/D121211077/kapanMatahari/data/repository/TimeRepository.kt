package com.D121211077.kapanMatahari.data.repository

import com.D121211077.kapanMatahari.data.response.GetTimeResponse
import com.D121211077.kapanMatahari.data.source.remote.ApiService

class TimeRepository(private val apiService: ApiService) {

    suspend fun getTime(lat: String, lng: String): GetTimeResponse {
        return apiService.getTime(lat, lng)
    }

}