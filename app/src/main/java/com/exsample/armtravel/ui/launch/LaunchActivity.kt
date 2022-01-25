package com.exsample.armtravel.ui.launch

import android.os.Bundle
import com.exsample.armtravel.R
//import com.betconstruct.betcocommon.swarm.SwarmViewModel

import com.exsample.armtravel.ui.BaseActivity
import org.koin.android.ext.android.inject
import org.koin.androidx.scope.lifecycleScope
import org.koin.androidx.viewmodel.scope.viewModel

class LaunchActivity : BaseActivity() {
    private val viewModel: LaunchViewModel by lifecycleScope.viewModel(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_launch)
    }
}