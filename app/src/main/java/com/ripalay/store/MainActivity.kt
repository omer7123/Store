package com.ripalay.store

import android.app.StatusBarManager
import android.content.Context
import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.navigation.NavController
import androidx.navigation.Navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import com.ripalay.store.core.network.result.Status
import com.ripalay.store.core.ui.BaseActivity
import com.ripalay.store.databinding.ActivityMainBinding
import com.ripalay.youtubeapi.core.ui.BaseViewModel
import com.ripalay.youtubeapi.extensions.showToast
import javax.net.ssl.SSLEngineResult

class MainActivity : BaseActivity<BaseViewModel, ActivityMainBinding>() {
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initDestination()
    }

    private fun initDestination() {
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        navController = navHostFragment.navController
        navController.addOnDestinationChangedListener { navController, destination, arguments ->
            if (destination.id != R.id.startFragment) {
                window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
            }
        }
    }

    override fun inflateVB(inflater: LayoutInflater): ActivityMainBinding {
        return ActivityMainBinding.inflate(layoutInflater)
    }

}