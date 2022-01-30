package com.ripalay.store.ui.profile_fragment

import androidx.fragment.app.viewModels
import by.kirich1409.viewbindingdelegate.viewBinding
import com.ripalay.store.R
import com.ripalay.store.core.ui.BaseFragment
import com.ripalay.store.core.ui.BaseViewModel
import com.ripalay.store.databinding.FragmentProfileBinding

class ProfileFragment :
    BaseFragment<BaseViewModel, FragmentProfileBinding>(R.layout.fragment_profile) {

    override val viewModel: BaseViewModel by viewModels()
    override val binding: FragmentProfileBinding by viewBinding()
}