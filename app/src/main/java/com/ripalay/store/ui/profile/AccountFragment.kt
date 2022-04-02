package com.ripalay.store.ui.profile

import androidx.fragment.app.viewModels
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.ripalay.store.R
import com.ripalay.store.core.ui.BaseFragment
import com.ripalay.store.core.ui.BaseViewModel
import com.ripalay.store.databinding.FragmentAccountBinding

class AccountFragment :
    BaseFragment<BaseViewModel, FragmentAccountBinding>(R.layout.fragment_account) {

    private lateinit var navController: NavController
    override val viewModel: BaseViewModel by viewModels()
    override val binding: FragmentAccountBinding by viewBinding()

    override fun initListeners() {
        binding.tvProfile.setOnClickListener {
            navController.navigate(R.id.profileFragment)
        }

        binding.tvOrders.setOnClickListener {
            navController.navigate(R.id.ordersFragment)
        }

    }

    override fun initNavController() {
        navController = findNavController()
    }
}