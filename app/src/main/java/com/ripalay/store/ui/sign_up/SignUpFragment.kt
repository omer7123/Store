package com.ripalay.store.ui.sign_up

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.ripalay.store.databinding.FragmentSignUpBinding
import android.telephony.PhoneNumberFormattingTextWatcher
import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText
import androidx.core.graphics.drawable.DrawableCompat
import androidx.core.content.ContextCompat
import androidx.core.view.isVisible
import androidx.fragment.app.FragmentManager
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import com.ripalay.store.R

class SignUpFragment : Fragment() {

    private lateinit var binding: FragmentSignUpBinding
    private lateinit var navController: NavController

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = FragmentSignUpBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        navController = findNavController()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        textWatcher(binding.etSignupName, R.drawable.ic_user, R.drawable.ic_user_selected)
        textWatcher(binding.etSignupPhone, R.drawable.ic_phone, R.drawable.ic_phone_selected)
        binding.etSignupPhone.addTextChangedListener(PhoneNumberFormattingTextWatcher())
        textWatcher(binding.etSignupPassword, R.drawable.ic_password, R.drawable.ic_password_selected)
        lastTextWatcher()

        binding.tvEnter.setOnClickListener {
            navController.navigate(R.id.signInFragment)
        }
    }

    private fun textWatcher(et: EditText, ic: Int, ic2: Int) {
        et.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                if (s.toString().isEmpty()) {
                    var icon = ContextCompat.getDrawable(requireActivity(), ic)
                    icon = DrawableCompat.wrap(icon!!)
                    et.setCompoundDrawablesWithIntrinsicBounds(icon, null, null, null)
                }
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                if (count > 0) {
                    var icon = ContextCompat.getDrawable(requireActivity(), ic2)
                    icon = DrawableCompat.wrap(icon!!)
                    et.setCompoundDrawablesWithIntrinsicBounds(icon, null, null, null)
                }
            }
        })
    }

    private fun lastTextWatcher() {
        binding.etSignupConfirmPass.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                if (s.toString().isEmpty()) {
                    var icon =
                        ContextCompat.getDrawable(requireActivity(), R.drawable.ic_password)
                    icon = DrawableCompat.wrap(icon!!)
                    binding.etSignupConfirmPass.setCompoundDrawablesWithIntrinsicBounds(icon,
                        null,
                        null,
                        null)
                    binding.btnSignup.setBackgroundResource(R.drawable.bg_btn_inactive)
                    binding.btnSignup.setTextColor(ContextCompat.getColor(requireContext(),
                        R.color.label_black_30))
                    binding.linLayout1.isVisible = false
                    binding.linLayout2.isVisible = true
                    binding.linLayout3.isVisible = true
                }
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                if (count > 0) {
                    var icon =
                        ContextCompat.getDrawable(requireActivity(),
                            R.drawable.ic_password_selected)
                    icon = DrawableCompat.wrap(icon!!)
                    binding.etSignupConfirmPass.setCompoundDrawablesWithIntrinsicBounds(icon,
                        null,
                        null,
                        null)
                    binding.btnSignup.setBackgroundResource(R.drawable.bg_btn_active)
                    binding.btnSignup.setTextColor(ContextCompat.getColor(requireContext(),
                        R.color.white))
                    binding.linLayout1.isVisible = true
                    binding.linLayout2.isVisible = false
                    binding.linLayout3.isVisible = false
                }
            }
        })
    }
}