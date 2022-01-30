package com.ripalay.store.ui.password_recovery

import android.telephony.PhoneNumberFormattingTextWatcher
import androidx.core.content.ContextCompat
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.viewModels
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.ripalay.store.R
import com.ripalay.store.core.ui.BaseFragment
import com.ripalay.store.core.ui.BaseViewModel
import com.ripalay.store.databinding.FragmentPasswordRecoveryBinding

class PasswordRecoveryFragment : BaseFragment<BaseViewModel, FragmentPasswordRecoveryBinding>
    (R.layout.fragment_password_recovery) {

    override val viewModel: BaseViewModel by viewModels()
    override val binding: FragmentPasswordRecoveryBinding by viewBinding()
    private lateinit var navController: NavController

    override fun initViews() {
        binding.sendBtn.isEnabled = false
        binding.numberEt.addTextChangedListener(PhoneNumberFormattingTextWatcher())
        binding.numberEt.addTextChangedListener {
            if (it.toString().isNotEmpty()) {
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
            navController.navigate(R.id.enterTokenFragment)
        }
    }

    override fun initNavController() {
        navController = findNavController()
    }
}