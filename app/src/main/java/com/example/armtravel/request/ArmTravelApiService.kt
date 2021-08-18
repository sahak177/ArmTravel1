package com.example.mymodul.util.request


import com.example.mymodul.model.*
import retrofit2.Call
import retrofit2.http.*

interface ArmTravelApiService {


    @Headers("Content-Type: application/json")
    @POST("add_device")
    suspend fun addDevice(@Body clientInfo: ClientInfo): Call<ClientInfo>


    @Headers("Content-Type: application/json")
    @POST("add_user")
    suspend fun signUp(@Body user: User): Call<String>

    @Headers("Content-Type: application/json")
    @POST("add_user")
    suspend fun signIn(@Body loginRequest: LoginRequest): Call<User>

    @Headers("Content-Type: application/json")
    @POST("add_user")
    suspend fun addPlace(@Body placeItem: PlaceItem): Call<String>


    @GET("/get_interests_place")
    suspend fun getInterestPlaceList(): Call<List<PlaceItem>?>?



    @Headers("Content-Type: application/json")
    @POST("get_places")
    suspend fun getPlaceListByCategories(@Body myLocation: MyLocation,
                                 @Body categories:List<String>,
                                 @Body distance:Int): Call<List<PlaceItem>?>





}