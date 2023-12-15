package com.D121211077.kapanMatahari.data

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import com.D121211077.kapanMatahari.data.repository.TimeRepository
import com.D121211077.kapanMatahari.data.source.remote.ApiService
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit

interface AppContainer {
    val timeRepository: TimeRepository
}

class DefaultAppContainer: AppContainer {

    private val BASE_URL = "https://api.sunrise-sunset.org/"

    private val retrofit = Retrofit.Builder()
        .addConverterFactory(Json.asConverterFactory("application/json".toMediaType()))
        .baseUrl(BASE_URL)
        .build()

    private val retrofitService : ApiService by lazy {
        retrofit.create(ApiService::class.java)
    }

    override val timeRepository: TimeRepository
        get() = TimeRepository(retrofitService)

}