package com.ripalay.store.ui.password_recovery

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.core.widget.addTextChangedListener
import com.ripalay.store.R
import com.ripalay.store.databinding.FragmentPasswordRecoveryBinding
import com.ripalay.store.databinding.FragmentStartBinding

class PasswordRecoveryFragment : Fragment() {
    private lateinit var binding: FragmentPasswordRecoveryBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentPasswordRecoveryBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initEditText()
    }



    private fun initEditText() {
        binding.numberEt.addTextChangedListener {
            if (it.toString().isNotEmpty()) {
                binding.sendBtn.setBackgroundResource(R.drawable.bg_btn_active)
                binding.sendBtn.setTextColor(
                    ContextCompat.getColor(
                        requireContext(),
                        R.color.white
                    )
                )
            } else {
                binding.sendBtn.setBackgroundResource(R.drawable.bg_btn_inactive)
                binding.sendBtn.setTextColor(
                    ContextCompat.getColor(
                        requireContext(),
                        R.color.black
                    )
                )
            }
        }
    }
}