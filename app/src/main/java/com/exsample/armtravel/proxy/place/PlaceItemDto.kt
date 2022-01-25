package com.exsample.armtravel.proxy.place

import com.google.gson.annotations.SerializedName

class PlaceItemDto (
    @SerializedName("title")
    var title: String?,
    @SerializedName("image")
    var imageUrl: String){

}