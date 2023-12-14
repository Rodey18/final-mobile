package com.D121211077.kapanMatahari.data.source.remote

import com.D121211077.kapanMatahari.data.response.GetTimeResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("json")
    suspend fun getTime(
        @Query("lat") lat: String,
        @Query("lng") lng: String
    ): GetTimeResponse
}

