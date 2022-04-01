package com.ripalay.store.ui.activity

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import androidx.core.view.isVisible
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import com.ripalay.store.App
import com.ripalay.store.R
import com.ripalay.store.core.network.result.Status
import com.ripalay.store.core.ui.BaseActivity
import com.ripalay.store.databinding.ActivityMainBinding
import com.ripalay.store.core.ui.BaseViewModel
import com.ripalay.store.data.local.prefs.Prefs
import com.ripalay.store.data.remote.models.Tokens
import com.ripalay.store.ui.sign_in.SignInViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : BaseActivity<SignInViewModel, ActivityMainBinding>() {

    private lateinit var navController: NavController

    override val viewModel: SignInViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initNavControllerWithBottomNav()
        initDestination()
        initCheckLog()
    }

    override fun initView() {
        super.initView()
        viewModel.loading.observe(this){
            binding.progress.isVisible = it
        }
    }
    private fun initCheckLog() {
        Log.e("ROOM",App.database.loginDao().getLogin().toString())
        if (App.database.loginDao().getLogin().isNotEmpty()) {
            viewModel.postLogin(App.database.loginDao().getLogin().get(0)).observe(this) {
                when (it.status) {
                    Status.SUCCESS -> {
                        val prefs = Prefs(this)
                        val tokens: Tokens? = it.data
                        prefs.saveAccess(tokens?.access.toString())
                        Log.e("token", prefs.getAccess().toString())
                        navController.navigate(R.id.action_startFragment_to_homeFragment2)
                        viewModel.loading.postValue(false)
                    }
                    Status.ERROR -> {
                        viewModel.loading.postValue(false)
                    }
                    Status.LOADING->{
                        viewModel.loading.postValue(true)
                    }
                }
            }
        }
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
            } else {
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