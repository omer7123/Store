package com.ripalay.store.ui.sign_up

import android.telephony.PhoneNumberFormattingTextWatcher
import android.util.Log
import android.widget.EditText
import androidx.core.content.ContextCompat
import androidx.core.graphics.drawable.DrawableCompat
import androidx.core.view.isVisible
import androidx.core.widget.addTextChangedListener
import androidx.core.widget.doAfterTextChanged
import androidx.fragment.app.viewModels
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.ripalay.store.R
import com.ripalay.store.core.network.result.Status
import com.ripalay.store.core.ui.BaseFragment
import com.ripalay.store.core.ui.BaseViewModel
import com.ripalay.store.data.remote.StoreApi
import com.ripalay.store.data.remote.models.Register
import com.ripalay.store.databinding.FragmentSignUpBinding
import org.koin.android.ext.android.bind
import org.koin.androidx.viewmodel.ext.android.viewModel

class SignUpFragment :
    BaseFragment<SignUpViewModel, FragmentSignUpBinding>(R.layout.fragment_sign_up) {

    override val viewModel: SignUpViewModel by viewModel()
    override val binding: FragmentSignUpBinding by viewBinding()
    private lateinit var navController: NavController

    override fun initViews() {
        textWatcher(binding.etSignupName, R.drawable.ic_user, R.drawable.ic_user_selected)
        textWatcher(binding.etSignupPhone, R.drawable.ic_phone, R.drawable.ic_phone_selected)
        binding.etSignupPhone.addTextChangedListener(PhoneNumberFormattingTextWatcher())
        textWatcher(
            binding.etSignupPassword,
            R.drawable.ic_password,
            R.drawable.ic_password_selected
        )
        textWatcher(
            binding.etSignupConfirmPass,
            R.drawable.ic_password,
            R.drawable.ic_password_selected
        )
    }

    override fun initListeners() {
        binding.tvEnter.setOnClickListener {
            navController.navigate(R.id.signInFragment)
        }
        binding.btnSignup.setOnClickListener {
            val username: String = binding.etSignupName.text.toString()
            val password: String = binding.etSignupPassword.text.toString()
            val password2 :String = binding.etSignupConfirmPass.text.toString()
            val email: String = binding.etSignupPhone.text.toString()

            viewModel.postRegister(Register(0, email, username, password, password2)).observe(this) {
                when (it.status) {
                    Status.SUCCESS -> {

                        Log.e("REGISTER", "SUCCESS")
                    }
                    Status.ERROR -> {

                    }
                }
            }
        }
    }

    private fun textWatcher(et: EditText, ic: Int, ic2: Int) {
        et.doAfterTextChanged {
            if (it.toString().isEmpty()) {
                var icon = ContextCompat.getDrawable(requireActivity(), ic)
                icon = DrawableCompat.wrap(icon!!)
                et.setCompoundDrawablesWithIntrinsicBounds(icon, null, null, null)

                binding.btnSignup.setBackgroundResource(R.drawable.bg_btn_inactive)
                binding.btnSignup.setTextColor(
                    ContextCompat.getColor(
                        requireContext(),
                        R.color.label_black_30
                    )
                )
                binding.linLayout1.isVisible = false
                binding.linLayout2.isVisible = true
                binding.linLayout3.isVisible = true
            } else {
                var icon = ContextCompat.getDrawable(requireActivity(), ic2)
                icon = DrawableCompat.wrap(icon!!)
                et.setCompoundDrawablesWithIntrinsicBounds(icon, null, null, null)
                binding.btnSignup.setBackgroundResource(R.drawable.bg_btn_active)
                binding.btnSignup.setTextColor(
                    ContextCompat.getColor(
                        requireContext(),
                        R.color.white
                    )
                )

                binding.linLayout1.isVisible = true
                binding.linLayout2.isVisible = false
                binding.linLayout3.isVisible = false
            }
        }
    }

    override fun initNavController() {
        navController = findNavController()
    }
}