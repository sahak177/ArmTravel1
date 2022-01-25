package com.exsample.armtravel.ui

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import androidx.annotation.IdRes
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.navigation.NavController
import com.exsample.armtravel.R
import com.exsample.armtravel.databinding.ActivityHomeBinding
import com.exsample.armtravel.ui.base.utils.clearBackStack
import com.exsample.armtravel.ui.base.utils.setupWithNavController
import com.exsample.armtravel.ui.place.placeViewModel
import org.koin.androidx.scope.lifecycleScope
import org.koin.androidx.viewmodel.scope.viewModel

class HomeActivity : BaseActivity() {

    var binding: ActivityHomeBinding? = null
    var currentNavController: LiveData<NavController>? = null
    val placeViewModel: placeViewModel by lifecycleScope.viewModel<placeViewModel>(this)

    private val navigationDestinationHandler = Handler(Looper.getMainLooper())
    private val navigationDestinationRunnable = Runnable {
        currentNavController?.value?.currentDestination?.id?.let {
            detectBottomNavigationBarVisibility(
                destinationId = it
            )
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_home)
        if (savedInstanceState == null) {
            setupBottomNavigationBar()
        }
        observeLiveData()
    }

    private fun observeLiveData() {

    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)

        // Now that BottomNavigationBar has restored its instance state
        // and its selectedItemId, we can proceed with setting up the
        // BottomNavigationBar with Navigation
        setupBottomNavigationBar()
    }

    override fun onDestroy() {
        super.onDestroy()
        binding?.unbind()
        binding = null
    }

    private fun setupBottomNavigationBar() {
        binding?.bottomNavigationView?.itemIconTintList = null

        val navGraphIds: List<Int> = listOf(
            R.navigation.nav_graph_place,
            R.navigation.nav_graph_favorite
        )
        val controller = binding?.bottomNavigationView?.setupWithNavController(
            navGraphIds = navGraphIds,
            fragmentManager = supportFragmentManager,
            containerId = R.id.nav_host_container,
            intent = intent
        )

        currentNavController = controller

        controller?.observe(this, Observer { navController ->
            when (navController.graph.startDestination) {

                R.id.placeFakeFragment -> setConditionalStartDestination(
                    navController,
                    R.id.placeFragment
                )
                R.id.favoriteFakeFragment -> setConditionalStartDestination(
                    navController,
                    R.id.favoriteFragment
                )
            }

            navController.addOnDestinationChangedListener { _, destination, _ ->
                detectBottomNavigationBarVisibility(destination.id)

                navigationDestinationHandler.removeCallbacks(navigationDestinationRunnable)
                navigationDestinationHandler.postDelayed(navigationDestinationRunnable, 1000)
            }
        })

    }

    private fun detectBottomNavigationBarVisibility(destinationId: Int) {
        if (bottomViewDestinationsThatShouldBeVisible.contains(destinationId)) {
            binding?.bottomNavigationView?.visibility = View.VISIBLE
        } else {
            binding?.bottomNavigationView?.visibility = View.GONE
        }
    }

    private val bottomViewDestinationsThatShouldBeVisible: ArrayList<Int> = arrayListOf(
        R.id.placeFragment,
        R.id.favoriteFragment
    )

    private fun setConditionalStartDestination(
        navController: NavController,
        @IdRes startDestId: Int
    ) {
        navController.setGraph(R.navigation.nav_graph_home_general)
        val graph = navController.graph
        graph.startDestination = startDestId
        navController.graph = graph
    }

    fun clearBackStackAndNavigateTo(menuId: Int, destinationId: Int) =
        currentNavController?.value?.run {
            clearBackStack()
            setSelectedBottomNavigationView(menuId)
            if (destinationId != currentNavController?.value?.currentDestination?.id) {
//                navigateSafe(destinationId)
            }
        }

    fun setSelectedBottomNavigationView(menuId: Int) {
        if (menuId != binding?.bottomNavigationView?.selectedItemId) {
            binding?.bottomNavigationView?.selectedItemId = menuId
        }
    }
}