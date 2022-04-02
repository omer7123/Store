package com.ripalay.store.ui.profile.order_details

import androidx.fragment.app.viewModels
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.ripalay.store.R
import com.ripalay.store.core.ui.BaseFragment
import com.ripalay.store.core.ui.BaseViewModel
import com.ripalay.store.data.remote.models.Order
import com.ripalay.store.databinding.FragmentOrderDetailsBinding

class OrderDetailsFragment :
    BaseFragment<BaseViewModel, FragmentOrderDetailsBinding>(R.layout.fragment_order_details) {

    private lateinit var navController: NavController
    override val viewModel: BaseViewModel by viewModels()
    override val binding: FragmentOrderDetailsBinding by viewBinding()

    override fun initViews() {
        val order = requireArguments().getSerializable("order") as Order?
        binding.tvId.text = order?.id.toString()
        binding.tvDate.text = order?.date.toString()
        binding.tvStatus.text = order?.status.toString()
    }

    override fun initListeners() {
        binding.fabBack.setOnClickListener {
            activity?.onBackPressed()
        }
    }

    override fun initNavController() {
        navController = findNavController()
    }

}