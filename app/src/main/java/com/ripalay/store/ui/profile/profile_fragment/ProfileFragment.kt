package com.ripalay.store.ui.profile.profile_fragment

import androidx.core.view.isVisible
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.ripalay.store.R
import com.ripalay.store.core.network.result.Status
import com.ripalay.store.core.ui.BaseFragment
import com.ripalay.store.data.local.prefs.Prefs
import com.ripalay.store.data.remote.models.User
import com.ripalay.store.databinding.FragmentProfileBinding
import org.koin.android.ext.android.bind
import org.koin.androidx.viewmodel.ext.android.viewModel

class ProfileFragment :
    BaseFragment<ProfileViewModel, FragmentProfileBinding>(R.layout.fragment_profile) {

    private lateinit var navController: NavController
    override val viewModel: ProfileViewModel by viewModel()
    override val binding: FragmentProfileBinding by viewBinding()

    override fun initViews() {
        binding.tvEdited.isVisible = false
    }

    override fun initListeners() {
        binding.fabBack.setOnClickListener {
            activity?.onBackPressed()
        }

        binding.btnEditProfile.setOnClickListener {
            binding.tvUsername.isVisible = false
            binding.etUsername.isVisible = true
            binding.tvEMail.isVisible = false
            binding.etEMail.isVisible = true
            binding.btnEditProfile.isVisible = false
            binding.btnEdit.isVisible = true
        }

        binding.btnEdit.setOnClickListener {

            val prefs = Prefs(requireContext())
            val accessToken: String = prefs.getAccess().toString()

            val userName: String = binding.etUsername.text.toString()
            val eMail: String = binding.etEMail.text.toString()

            viewModel.updateUser("JWT $accessToken", userName, eMail).observe(this) {
                when (it.status) {
                    Status.SUCCESS -> {
                        binding.tvEdited.isVisible = true
                    }
                    Status.LOADING -> {
                    }
                }
            }

            binding.tvUsername.isVisible = true
            binding.etUsername.isVisible = false
            binding.tvEMail.isVisible = true
            binding.etEMail.isVisible = false
            binding.btnEditProfile.isVisible = true
            binding.btnEdit.isVisible = false
        }
    }

    override fun initObservers() {
        val prefs = Prefs(requireContext())
        val accessToken: String = prefs.getAccess().toString()
        viewModel.getUser("JWT $accessToken").observe(this) {
            if (it.status == Status.SUCCESS) {
                setProfileData(it.data)
            } else if (it.status == Status.LOADING) {
            }
        }
    }

    private fun setProfileData(user: User?) {
        binding.tvEMail.text = user?.eMail.toString()
        binding.tvUsername.text = user?.userName.toString()
        binding.etEMail.setText(user?.eMail.toString())
        binding.etUsername.setText(user?.userName.toString())
    }

    override fun initNavController() {
        navController = findNavController()
    }
}