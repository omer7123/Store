package com.ripalay.store.ui.sign_in

import android.os.Bundle
import android.telephony.PhoneNumberFormattingTextWatcher
import android.text.Editable
import android.text.TextWatcher
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import androidx.core.content.ContextCompat
import androidx.core.graphics.drawable.DrawableCompat
import androidx.core.widget.doAfterTextChanged
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import com.ripalay.store.databinding.FragmentSignInBinding
import com.ripalay.store.R

class SignInFragment : Fragment() {

    private lateinit var binding: FragmentSignInBinding
    private lateinit var navController: NavController

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = FragmentSignInBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        navController = findNavController()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.etSignInPhone.addTextChangedListener(PhoneNumberFormattingTextWatcher())
        textWatcher(binding.etSignInPhone, R.drawable.ic_phone, R.drawable.ic_phone_selected)
        textWatcher(binding.etSignInPassword, R.drawable.ic_password, R.drawable.ic_password_selected)

        binding.tvSignUp.setOnClickListener {
            navController.navigate(R.id.signUpFragment)
        }
    }

    private fun textWatcher(et: EditText, ic: Int, ic2: Int) {
        et.doAfterTextChanged {
            if (it.toString().isEmpty()) {
                var icon = ContextCompat.getDrawable(requireActivity(), ic)
                icon = DrawableCompat.wrap(icon!!)
                et.setCompoundDrawablesWithIntrinsicBounds(icon, null, null, null)

                binding.btnSignIn.setBackgroundResource(R.drawable.bg_btn_inactive)
                binding.btnSignIn.setTextColor(ContextCompat.getColor(requireContext(),
                    R.color.label_black_30))
            } else {
                var icon = ContextCompat.getDrawable(requireActivity(), ic2)
                icon = DrawableCompat.wrap(icon!!)
                et.setCompoundDrawablesWithIntrinsicBounds(icon, null, null, null)

                binding.btnSignIn.setBackgroundResource(R.drawable.bg_btn_active)
                binding.btnSignIn.setTextColor(ContextCompat.getColor(requireContext(),
                    R.color.white))
            }
        }
    }

}