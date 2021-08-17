package com.example.mymodul.model

import com.google.gson.annotations.SerializedName
import java.util.*

class PlaceItem (
    @SerializedName("place_id") var id: Int,
    @SerializedName("title")var title: String,
    @SerializedName("description")var Description: String,
    @SerializedName("location")var location : MyLocation,
    @SerializedName("images")var images: List<String>,
    @SerializedName("distance")var distance: Int,
    @SerializedName("categories")var categories: String,
    @SerializedName("date") var date: Date
)
