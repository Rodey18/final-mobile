package com.D121211077.kapanMatahari.data.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Parcelize
@Serializable
data class Article(
    @SerialName("sunrise")
    val sunrise: String?,
    @SerialName("sunset")
    val sunset: String?,
    @SerialName("solar_noon")
    val solarNoon: String?,
    @SerialName("civil_twilight_begin")
    val civilTwilightBegin: String?,
    @SerialName("civil_twilight_end")
    val civilTwilightEnd: String?,
    @SerialName("nautical_twilight_begin")
    val nauticalTwilightBegin: String?,
    @SerialName("nautical_twilight_end")
    val nauticalTwilightEnd: String?,
    @SerialName("astronomical_twilight_begin")
    val astronomicalTwilightBegin: String?,
    @SerialName("astronomical_twilight_end")
    val astronomicalTwilightEnd: String?
) : Parcelable