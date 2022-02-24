package com.ripalay.store

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import com.ripalay.store.core.ui.BaseActivity
import com.ripalay.store.databinding.ActivityMainBinding
import com.ripalay.store.core.ui.BaseViewModel

class MainActivity : BaseActivity<BaseViewModel, ActivityMainBinding>() {

    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        initNavControllerWithBottomNav()
        initDestination()
    }


    private fun initDestination() {
        navController.addOnDestinationChangedListener { navController, destination, arguments ->
            if (destination.id != R.id.startFragment) {
                window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
            }
            if (destination.id == R.id.startFragment ||
                destination.id == R.id.signInFragment ||
                destination.id == R.id.signUpFragment ||
                destination.id == R.id.passwordRecoveryFragment ||
                destination.id == R.id.enterTokenFragment ||
                destination.id == R.id.createNewPasswordFragment
            ) {
                binding.cardNav.visibility = View.GONE
            }else{
                binding.cardNav.visibility = View.VISIBLE
            }
        }
    }

    private fun initNavControllerWithBottomNav() {
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        navController = navHostFragment.navController
        NavigationUI.setupWithNavController(binding.navView, navController)
    }

    override fun inflateVB(inflater: LayoutInflater): ActivityMainBinding {
        return ActivityMainBinding.inflate(layoutInflater)
    }

}