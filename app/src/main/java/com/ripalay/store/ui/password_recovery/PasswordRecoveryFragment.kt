package com.ripalay.store.ui.password_recovery

import android.os.Bundle
import android.telephony.PhoneNumberFormattingTextWatcher
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.core.widget.addTextChangedListener
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import com.ripalay.store.R
import com.ripalay.store.databinding.FragmentPasswordRecoveryBinding
import com.ripalay.store.databinding.FragmentStartBinding

class PasswordRecoveryFragment : Fragment() {
    private lateinit var binding: FragmentPasswordRecoveryBinding
    private lateinit var navController: NavController

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentPasswordRecoveryBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = findNavController()
        initEditText()
        initListener()
    }

    private fun initEditText() {
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

    private fun initListener() {
        binding.sendBtn.setOnClickListener {
            navController.navigate(R.id.enterTokenFragment)
        }
    }

}