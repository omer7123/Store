package com.ripalay.store.ui.enter_token_fragment

import androidx.core.content.ContextCompat
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.viewModels
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.ripalay.store.R
import com.ripalay.store.core.ui.BaseFragment
import com.ripalay.store.core.ui.BaseViewModel
import com.ripalay.store.databinding.FragmentEnterTokenBinding

class EnterTokenFragment : BaseFragment<BaseViewModel, FragmentEnterTokenBinding>
    (R.layout.fragment_enter_token){

    override val viewModel: BaseViewModel by viewModels()
    override val binding: FragmentEnterTokenBinding by viewBinding()
    private lateinit var navController: NavController

    override fun initViews() {
        binding.sendBtn.isEnabled = false
        binding.tokenEt.addTextChangedListener {
            if (it.toString().length == 6) {
                binding.sendBtn.setBackgroundResource(R.drawable.bg_btn_active)
                binding.sendBtn.setTextColor(
                    ContextCompat.getColor(
                        requireContext(),
                        R.color.white
                    )
                )
                binding.sendBtn.isEnabled = true
            } else {
                binding.sendBtn.setBackgroundResource(R.drawable.bg_btn_inactive)
                binding.sendBtn.setTextColor(
                    ContextCompat.getColor(
                        requireContext(),
                        R.color.black_with_alfa
                    )
                )
                binding.sendBtn.isEnabled = false
            }
        }
    }

    override fun initListeners() {
        binding.sendBtn.setOnClickListener {
            navController.navigate(R.id.createNewPasswordFragment)
        }
    }

    override fun initNavController() {
        navController = findNavController()
    }
}