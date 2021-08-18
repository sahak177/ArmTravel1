package com.example.armtravel.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mymodul.listeners.ApiCallback
import com.example.mymodul.model.*
import com.example.mymodul.util.request.ArmTravelRepository
import com.example.mymodul.util.request.ArmTravelRepositoryImpl
import kotlinx.coroutines.GlobalScope.coroutineContext
import kotlinx.coroutines.launch

class PlaceViewModel(private val armTravelRepository: ArmTravelRepository): ViewModel() {


    private val _interestPlaceItemListLiveData = MutableLiveData<List<PlaceItem>?>()
    val interestPlaceItemListLiveData: LiveData<List<PlaceItem>?>
        get() = _interestPlaceItemListLiveData

    fun getInterestPlaceList() {
        viewModelScope.launch(coroutineContext) {
           armTravelRepository.getInterestPlaceList(object : ApiCallback<List<PlaceItem>?> {
               override fun onSuccess(data: List<PlaceItem>?) {
                       _interestPlaceItemListLiveData.postValue(data)
               }
           })
        }
    }



    private val _placeItemListLiveData = MutableLiveData<List<PlaceItem>?>()
    val placeItemListLiveData: LiveData<List<PlaceItem>?>
        get() = _placeItemListLiveData

    fun getPlaceListByCategories(myLocation: MyLocation, categories: List<String>, distance:Int) {
        viewModelScope.launch(coroutineContext) {
            armTravelRepository.getPlaceListByCategories(myLocation,categories,distance,object : ApiCallback<List<PlaceItem>?> {
                override fun onSuccess(data: List<PlaceItem>?) {
                        _placeItemListLiveData.postValue(data)
                }
            })
        }
    }



    private val _addPlaceLiveData = MutableLiveData<String>()
    val addPlaceLiveData: LiveData<String>
        get() = _addPlaceLiveData

    fun addPlace(placeItem: PlaceItem) {
        viewModelScope.launch(coroutineContext) {
            armTravelRepository.addPlace(placeItem,object : ApiCallback<String?> {
                override fun onSuccess(data: String?) {
                        _addPlaceLiveData.postValue(data)
                }
            })
        }
    }



    private val _signInLiveData = MutableLiveData<User>()
    val signInLiveData: LiveData<User>
        get() = _signInLiveData

    fun signIn(loginRequest: LoginRequest) {
        viewModelScope.launch(coroutineContext) {
            armTravelRepository.signIn(loginRequest,object : ApiCallback<User?> {
                override fun onSuccess(data: User?) {
                        _signInLiveData.postValue(data)
                }
            })
        }
    }



    private val _signUpLiveData = MutableLiveData<String>()
    val signUpLiveData: LiveData<String>
        get() = _signUpLiveData

    fun signUp(user: User) {
        viewModelScope.launch(coroutineContext) {
            armTravelRepository.signUp(user,object : ApiCallback<String?> {
                override fun onSuccess(data: String?) {
                        _signUpLiveData.postValue(data)
                }
            })
        }
    }



    private val _clientInfoLiveData = MutableLiveData<ClientInfo>()
    val clientInfoLiveData: LiveData<ClientInfo>
        get() = _clientInfoLiveData

    fun addDevice(clientInfo: ClientInfo) {
        viewModelScope.launch(coroutineContext) {
            armTravelRepository.addDevice(clientInfo,object : ApiCallback<ClientInfo?> {
                override fun onSuccess(data: ClientInfo?) {
                    _clientInfoLiveData.postValue(data)
                }
            })
        }
    }

}

