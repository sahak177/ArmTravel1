package com.example.mymodul.model

import com.google.gson.annotations.SerializedName

class LoginRequest(
    @SerializedName("device_key") val deviceKey:String,
    @SerializedName("app_key") val appKey: String?,
    @SerializedName("mail") val mail:String,
    @SerializedName("password")var password: String
) {


}