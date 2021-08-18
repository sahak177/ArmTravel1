package com.example.mymodul.listeners

interface ApiCallback<T> {
    fun onSuccess(data: T?)
    fun onError(error:String){}
    fun onFailure(error:Throwable){}
}