package com.ripalay.store.ui.start

import androidx.fragment.app.viewModels
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.ripalay.store.R
import com.ripalay.store.core.ui.BaseFragment
import com.ripalay.store.core.ui.BaseViewModel
import com.ripalay.store.databinding.FragmentStartBinding

class StartFragment : BaseFragment<BaseViewModel, FragmentStartBinding>(R.layout.fragment_start) {

    override val viewModel: BaseViewModel by viewModels()
    override val binding: FragmentStartBinding by viewBinding()
    private lateinit var navController: NavController

    override fun initListeners() {
        binding.registerBtn.setOnClickListener {
            navController.navigate(R.id.signUpFragment)
        }
        binding.signInBtn.setOnClickListener {
            navController.navigate(R.id.signInFragment)
        }
    }

    override fun initNavController() {
        navController = findNavController()
    }
}