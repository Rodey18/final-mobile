package com.D121211077.kapanMatahari.data.response

import com.D121211077.kapanMatahari.data.models.SunInfo
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class GetTimeResponse(
    @SerialName("results")
    val results: SunInfo?,
    @SerialName("status")
    val status: String?,
    @SerialName("tzId")
    val tzId: String?
)