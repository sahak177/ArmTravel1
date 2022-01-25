package com.exsample.armtravel.ui.di


import com.exsample.armtravel.ui.HomeActivity
import com.exsample.armtravel.ui.place.placeViewModel
import com.exsample.armtravel.ui.launch.LaunchActivity
import com.exsample.armtravel.ui.launch.LaunchViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.qualifier.named
import org.koin.dsl.module

val casinoLightMainModule = module {


    scope(named<LaunchActivity>()) {
        viewModel { LaunchViewModel() }
    }

    scope(named<HomeActivity>()) {
        viewModel { placeViewModel() }
    }
}

