package com.ripalay.store.ui.sign_in

import android.telephony.PhoneNumberFormattingTextWatcher
import android.widget.EditText
import androidx.core.content.ContextCompat
import androidx.core.graphics.drawable.DrawableCompat
import androidx.core.widget.doAfterTextChanged
import androidx.fragment.app.viewModels
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.ripalay.store.R
import com.ripalay.store.core.ui.BaseFragment
import com.ripalay.store.core.ui.BaseViewModel
import com.ripalay.store.databinding.FragmentSignInBinding

class SignInFragment : BaseFragment<BaseViewModel, FragmentSignInBinding>
    (R.layout.fragment_sign_in) {

    override val viewModel: BaseViewModel by viewModels()
    override val binding: FragmentSignInBinding by viewBinding()
    private lateinit var navController: NavController

    override fun initViews() {
        binding.etSignInPhone.addTextChangedListener(PhoneNumberFormattingTextWatcher())
        textWatcher(binding.etSignInPhone, R.drawable.ic_phone, R.drawable.ic_phone_selected)
        textWatcher(binding.etSignInPassword, R.drawable.ic_password, R.drawable.ic_password_selected)
    }

    override fun initListeners() {
        binding.tvSignUp.setOnClickListener {
            navController.navigate(R.id.signUpFragment)
        }
        binding.tvRestore.setOnClickListener {
            navController.navigate(R.id.passwordRecoveryFragment)
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

    override fun initNavController() {
        navController = findNavController()
    }

}