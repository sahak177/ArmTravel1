package com.example.mymodul.util.request

import com.example.mymodul.listeners.*
import com.example.mymodul.model.*
import com.google.gson.Gson
import com.google.gson.JsonElement
import com.google.gson.JsonObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

interface ArmTravelRepository {

    suspend fun addDevice(clientInfo: ClientInfo, apiCallback: ApiCallback<ClientInfo?>)

    suspend fun signUp(user: User, apiCallback: ApiCallback<String?>)

    suspend fun signIn(loginRequest: LoginRequest,apiCallback: ApiCallback<User?>)

    suspend fun addPlace(placeItem: PlaceItem, apiCallback: ApiCallback<String?>)

    suspend fun getInterestPlaceList(apiCallback: ApiCallback<List<PlaceItem>?>)

    suspend fun getPlaceListByCategories(myLocation: MyLocation, categories: List<String>, distance: Int, apiCallback: ApiCallback<List<PlaceItem>?>)


}

class ArmTravelRepositoryImpl :ArmTravelRepository{
    val retrofit = ArmTravelRetrofitClient.buildService(ArmTravelApiService::class.java)

    override suspend fun addDevice(
        clientInfo: ClientInfo,
        apiCallback: ApiCallback<ClientInfo?>
    ) {
        retrofit.addDevice(clientInfo).enqueue(
            call(apiCallback)
        )
    }

    override suspend fun signUp(
        user: User,
        apiCallback: ApiCallback<String?>
    ) {
        retrofit.signUp(user).enqueue(
            call(apiCallback)
        )
    }

    override suspend fun signIn(
        loginRequest: LoginRequest,
        apiCallback: ApiCallback<User?>
    ) {
        retrofit.signIn(loginRequest).enqueue(
            call(apiCallback)
        )
    }

    override suspend fun addPlace(
        placeItem: PlaceItem,
        apiCallback: ApiCallback<String?>
    ) {
        retrofit.addPlace(placeItem).enqueue(
            call(apiCallback)
        )
    }

    override suspend fun getInterestPlaceList(apiCallback: ApiCallback<List<PlaceItem>?>) {
        retrofit.getInterestPlaceList()?.enqueue(
            call(apiCallback)
        )
    }

    override suspend fun getPlaceListByCategories(
        myLocation: MyLocation, categories: List<String>, distance: Int,
        apiCallback: ApiCallback<List<PlaceItem>?>
    ) {
        retrofit.getPlaceListByCategories(myLocation, categories, distance).enqueue(
            call(apiCallback)
        )
    }


    private fun <T> call(apiCallback: ApiCallback<T>): Callback<T> {
        return object : Callback<T> {
            override fun onResponse(call: Call<T>, response: Response<T>) {
                if (response.isSuccessful) {
                    apiCallback.onSuccess(response.body())
                } else {
                    apiCallback.onError(response.message())
                }
            }

            override fun onFailure(call: Call<T>, t: Throwable) {
                apiCallback.onFailure(t)
            }

        }
    }

}