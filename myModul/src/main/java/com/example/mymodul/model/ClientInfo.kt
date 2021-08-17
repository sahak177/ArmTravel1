package com.example.mymodul.model

import com.google.gson.annotations.SerializedName

data class ClientInfo(
    @SerializedName("device_key") val deviceKey: String?,
    @SerializedName("app_key") val appKey: String?,
    @SerializedName("beck_end_key") val beckEndKey: String?
)
