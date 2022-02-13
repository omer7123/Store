package com.ripalay.store.ui.catalogue

import android.os.Bundle
import android.util.Log
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.ripalay.store.R
import com.ripalay.store.core.network.result.Status
import com.ripalay.store.core.ui.BaseFragment
import com.ripalay.store.data.remote.models.Result
import com.ripalay.store.databinding.FragmentCatalogueBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class CatalogueFragment :
    BaseFragment<CatalogueViewModel, FragmentCatalogueBinding>(R.layout.fragment_catalogue) {

    private lateinit var navController: NavController

    override val viewModel: CatalogueViewModel by viewModel()
    override val binding: FragmentCatalogueBinding by viewBinding()
    private lateinit var adapter: CatalogueAdapter

    override fun initObservers() {
        super.initObservers()
        viewModel.getCaps().observe(this) {
            when (it.status) {
                Status.SUCCESS -> {
                    val item = it.data
                    adapter = CatalogueAdapter(
                        item?.results!!,
                        this::clickListener
                    )
                    binding.recyclerCatalogue.adapter = adapter
                    viewModel.loading.postValue(false)
                    Log.e("ololo", item.toString())
                }
                Status.LOADING -> {
                    viewModel.loading.postValue(true)
                }
            }
        }
    }

    private fun clickListener(result: Result) {
        val bundle = Bundle()
        bundle.putString("id", result.id.toString())
        navController.navigate(R.id.detailCapsFragment, bundle)
        adapter.onItemClick = {

        }
    }

    override fun initViews() {
        super.initViews()
        binding.recyclerCatalogue.apply {
            layoutManager = GridLayoutManager(requireContext(), 2)
        }
        viewModel.loading.observe(this) {
            binding.progress.isVisible = it
        }


    }

    override fun initNavController() {
        super.initNavController()
        navController = findNavController()
    }
}