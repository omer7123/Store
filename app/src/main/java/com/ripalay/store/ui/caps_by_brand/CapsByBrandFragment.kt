package com.ripalay.store.ui.caps_by_brand

import android.os.Bundle
import android.util.Log
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.ListAdapter
import by.kirich1409.viewbindingdelegate.viewBinding
import com.ripalay.store.R
import com.ripalay.store.core.network.result.Status
import com.ripalay.store.core.ui.BaseFragment
import com.ripalay.store.core.ui.BaseViewModel
import com.ripalay.store.data.remote.models.Results
import com.ripalay.store.databinding.FragmentCapsByBrandBinding
import com.ripalay.store.ui.catalogue.CatalogueAdapter
import org.koin.androidx.viewmodel.ext.android.viewModel

class CapsByBrandFragment :
    BaseFragment<CapsByBrandViewModel, FragmentCapsByBrandBinding>(R.layout.fragment_caps_by_brand) {

    private lateinit var navController: NavController
    private lateinit var adapter: CatalogueAdapter

    override val viewModel: CapsByBrandViewModel by viewModel()
    override val binding: FragmentCapsByBrandBinding by viewBinding()

    override fun initObservers() {
        super.initObservers()

        val bundle = arguments
        binding.brandNameTv.text = bundle?.getString("brandName")

        viewModel.loading.observe(requireActivity()) {
            binding.progress.isVisible = it
        }

        viewModel.getCapsBrand(bundle?.get("brandName").toString().lowercase()).observe(this) {
            when (it.status) {
                Status.SUCCESS -> {
                    viewModel.loading.postValue(false)
                    val item = it.data
                    adapter = CatalogueAdapter(
                        item?.results!!,
                        this::clickListener
                    )
                    binding.recyclerCatalogue.adapter = adapter
                }

                Status.LOADING -> {
                    viewModel.loading.postValue(true)
                }
            }
        }
    }

    private fun clickListener(cap: Results) {
        val bundle = Bundle()
        bundle.putString("id", cap.id.toString())
        navController.navigate(R.id.detailCapsFragment, bundle)
    }

    override fun initListeners() {
        super.initListeners()
        binding.backBtn.setOnClickListener {
            navController.popBackStack()
        }
    }

    override fun initViews() {
        super.initViews()
        binding.recyclerCatalogue.apply {
            layoutManager =
                GridLayoutManager(requireContext(), 2, GridLayoutManager.VERTICAL, false)
        }
    }

    override fun initNavController() {
        super.initNavController()
        navController = findNavController()
    }

}