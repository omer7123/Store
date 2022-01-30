package com.ripalay.store.ui.home_fragment

import androidx.fragment.app.viewModels
import by.kirich1409.viewbindingdelegate.viewBinding
import com.ripalay.store.R
import com.ripalay.store.core.ui.BaseFragment
import com.ripalay.store.core.ui.BaseViewModel
import com.ripalay.store.databinding.FragmentHomeBinding

class HomeFragment : BaseFragment<BaseViewModel, FragmentHomeBinding>(R.layout.fragment_home) {

    override val viewModel: BaseViewModel by viewModels()
    override val binding: FragmentHomeBinding by viewBinding()

}