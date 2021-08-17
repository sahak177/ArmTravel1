package com.example.mymodul.model

import com.google.gson.annotations.SerializedName

class MyLocation(
    @SerializedName("lat") var lat:Double,
    @SerializedName("let") var let:Double
) {
}