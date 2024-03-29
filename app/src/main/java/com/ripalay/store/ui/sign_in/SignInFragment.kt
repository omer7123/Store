package com.ripalay.store.ui.sign_in

import android.util.Log
import android.widget.EditText
import androidx.core.content.ContextCompat
import androidx.core.graphics.drawable.DrawableCompat
import androidx.core.view.isVisible
import androidx.core.widget.doAfterTextChanged
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.ripalay.store.App
import com.ripalay.store.R
import com.ripalay.store.core.network.result.Status
import com.ripalay.store.core.ui.BaseFragment
import com.ripalay.store.data.local.prefs.Prefs
import com.ripalay.store.data.remote.models.Register
import com.ripalay.store.data.remote.models.Tokens
import com.ripalay.store.databinding.FragmentSignInBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class SignInFragment : BaseFragment<SignInViewModel, FragmentSignInBinding>
    (R.layout.fragment_sign_in) {

    override val viewModel: SignInViewModel by viewModel()
    override val binding: FragmentSignInBinding by viewBinding()
    private lateinit var navController: NavController

    override fun initViews() {
//        binding.etSignInPhone.addTextChangedListener(PhoneNumberFormattingTextWatcher())
//        textWatcher(binding.etSignInPhone, R.drawable.ic_phone, R.drawable.ic_phone_selected)
//        textWatcher(
//            binding.etSignInPassword,
//            R.drawable.ic_password,
//            R.drawable.ic_password_selected
//        )
        binding.btnSignIn.setBackgroundResource(R.drawable.bg_btn_active)
        binding.btnSignIn.setTextColor(
            ContextCompat.getColor(
                requireContext(),
                R.color.white
            )
        )
    }

    override fun initListeners() {
        binding.tvSignUp.setOnClickListener {
            navController.navigate(R.id.signUpFragment)
        }
        binding.tvRestore.setOnClickListener {
            navController.navigate(R.id.passwordRecoveryFragment)
        }
        binding.btnSignIn.setOnClickListener {
            val username: String = binding.etSignInPhone.text.toString()
            val password: String = binding.etSignInPassword.text.toString()

            viewModel.postLogin(Register(null, "", username, password)).observe(this) {
                when (it.status) {
                    Status.SUCCESS -> {
                        App.database.loginDao().deleteList(App.database.loginDao().getLogin())
                        App.database.loginDao().addLoginItem(Register(null, "", username, password))
                        val prefs = Prefs(requireContext())
                        val tokens: Tokens? = it.data
                        prefs.saveAccess(tokens?.access.toString())
                        navController.navigate(R.id.action_startFragment_to_homeFragment2)
                        viewModel.loading.postValue(false)
                    }
                    Status.LOADING -> {
                        viewModel.loading.postValue(true)
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

                binding.btnSignIn.setBackgroundResource(R.drawable.bg_btn_inactive)
                binding.btnSignIn.setTextColor(
                    ContextCompat.getColor(
                        requireContext(),
                        R.color.label_black_30
                    )
                )
            } else {
                var icon = ContextCompat.getDrawable(requireActivity(), ic2)
                icon = DrawableCompat.wrap(icon!!)
                et.setCompoundDrawablesWithIntrinsicBounds(icon, null, null, null)

                binding.btnSignIn.setBackgroundResource(R.drawable.bg_btn_active)
                binding.btnSignIn.setTextColor(
                    ContextCompat.getColor(
                        requireContext(),
                        R.color.white
                    )
                )
            }
        }
    }

    override fun initObservers() {
        super.initObservers()
        viewModel.loading.observe(requireActivity()){
            binding.progress.isVisible = it
        }
    }

    override fun initNavController() {
        navController = findNavController()
    }

}