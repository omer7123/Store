package com.ripalay.store.ui.create_new_password_fragment

import androidx.core.content.ContextCompat
import androidx.core.graphics.drawable.DrawableCompat
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.viewModels
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.ripalay.store.R
import com.ripalay.store.core.ui.BaseFragment
import com.ripalay.store.core.ui.BaseViewModel
import com.ripalay.store.databinding.FragmentCreateNewPasswordBinding

class CreateNewPasswordFragment :
    BaseFragment<BaseViewModel, FragmentCreateNewPasswordBinding>(R.layout.fragment_create_new_password) {

    override val viewModel: BaseViewModel by viewModels()
    override val binding: FragmentCreateNewPasswordBinding by viewBinding()
    private lateinit var navController: NavController

    override fun initViews() {
        var iconPasswordSelect =
            ContextCompat.getDrawable(requireActivity(), R.drawable.ic_password_selected)
        iconPasswordSelect = DrawableCompat.wrap(iconPasswordSelect!!)

        var iconPassword = ContextCompat.getDrawable(requireActivity(), R.drawable.ic_password)
        iconPassword = DrawableCompat.wrap(iconPassword!!)

        binding.passwordEt.addTextChangedListener {
            binding.sendBtn.isEnabled = false
            if (it.toString().isNotEmpty()) {
                binding.passwordEt.setCompoundDrawablesWithIntrinsicBounds(
                    iconPasswordSelect,null,null,null
                )
                binding.acceptEt.addTextChangedListener { its ->
                    if (its.toString() == it.toString()) {
                        binding.sendBtn.setBackgroundResource(R.drawable.bg_btn_active)
                        binding.sendBtn.setTextColor(
                            ContextCompat.getColor(requireContext(), R.color.white))
                        binding.sendBtn.isEnabled = true
                    } else {
                        binding.sendBtn.setBackgroundResource(R.drawable.bg_btn_inactive)
                        binding.sendBtn.setTextColor(
                            ContextCompat.getColor(requireContext(), R.color.black_with_alfa))
                        binding.sendBtn.isEnabled = false
                    }
                }
            } else {
                binding.passwordEt.setCompoundDrawablesWithIntrinsicBounds(
                    iconPassword,null,null,null
                )
            }
        }
        binding.acceptEt.addTextChangedListener {
            if (it.toString().isNotEmpty()) {
                binding.acceptEt.setCompoundDrawablesWithIntrinsicBounds(
                    iconPasswordSelect,null,null,null
                )
            } else {
                binding.acceptEt.setCompoundDrawablesWithIntrinsicBounds(
                    iconPassword,null,null,null
                )
            }
        }
    }

    override fun initListeners() {
        binding.sendBtn.setOnClickListener {
            navController.navigate(R.id.homeFragment2)
        }
    }

    override fun initNavController() {
        navController = findNavController()
    }
}