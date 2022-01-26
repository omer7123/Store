package com.ripalay.store.ui.create_new_password_fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.core.graphics.drawable.DrawableCompat
import androidx.core.widget.addTextChangedListener
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import com.ripalay.store.R
import com.ripalay.store.databinding.FragmentCreateNewPasswordBinding

class CreateNewPasswordFragment : Fragment() {

    private lateinit var binding: FragmentCreateNewPasswordBinding
    private lateinit var navController: NavController


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCreateNewPasswordBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = findNavController()
        initEditText()
        initListener()
    }

    private fun initListener() {
        binding.sendBtn.setOnClickListener {
            navController.navigate(R.id.homeFragment2)
        }
    }

    private fun initEditText() {
        var iconPasswordSelect =
            ContextCompat.getDrawable(requireActivity(), R.drawable.ic_password_selected)
        iconPasswordSelect = DrawableCompat.wrap(iconPasswordSelect!!)

        var iconPassword = ContextCompat.getDrawable(requireActivity(), R.drawable.ic_password)
        iconPassword = DrawableCompat.wrap(iconPassword!!)

        binding.passwordEt.addTextChangedListener {
            binding.sendBtn.isEnabled = false
            if (it.toString().isNotEmpty()) {
                binding.passwordEt.setCompoundDrawablesWithIntrinsicBounds(
                    iconPasswordSelect,
                    null,
                    null,
                    null
                )
                binding.acceptEt.addTextChangedListener { its ->
                    if (its.toString() == it.toString()) {
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
            } else {
                binding.passwordEt.setCompoundDrawablesWithIntrinsicBounds(
                    iconPassword,
                    null,
                    null,
                    null
                )
            }
        }
        binding.acceptEt.addTextChangedListener {
            if (it.toString().isNotEmpty()) {
                binding.acceptEt.setCompoundDrawablesWithIntrinsicBounds(
                    iconPasswordSelect,
                    null,
                    null,
                    null
                )
            } else {
                binding.acceptEt.setCompoundDrawablesWithIntrinsicBounds(
                    iconPassword,
                    null,
                    null,
                    null
                )
            }
        }

    }
}