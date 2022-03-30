package com.ripalay.store.ui.sign_up

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import com.ripalay.store.R
import com.ripalay.store.databinding.ActivityMainBinding
import com.ripalay.store.databinding.FragmentNotificationSignUpBinding

class NotificationSignUpFragment : DialogFragment() {
    private lateinit var navController: NavController
    private lateinit var binding: FragmentNotificationSignUpBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        navController = findNavController()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentNotificationSignUpBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btn.setOnClickListener {
            navController.clearBackStack(R.id.notificationSignUpFragment)
            navController.navigate(R.id.signInFragment)
            this.dismiss()
        }
    }

}