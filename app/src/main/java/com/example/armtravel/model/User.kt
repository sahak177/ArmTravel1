package com.example.mymodul.model

import com.google.gson.annotations.SerializedName

class User(
    @SerializedName("lat") var id:Int,
    @SerializedName("lat") var nickName:String,
    @SerializedName("lat") var password:String,
    @SerializedName("lat") var mail:String,
    @SerializedName("lat") var avatarImage:String

    ) {
}