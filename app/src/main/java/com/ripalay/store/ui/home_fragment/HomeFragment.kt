package com.ripalay.store.ui.home_fragment

import android.os.Bundle
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.ripalay.store.R
import com.ripalay.store.core.network.result.Resource
import com.ripalay.store.core.network.result.Status
import com.ripalay.store.core.ui.BaseFragment
import com.ripalay.store.data.local.prefs.Prefs
import com.ripalay.store.data.remote.models.ResultBrand
import com.ripalay.store.data.remote.models.Results
import com.ripalay.store.databinding.FragmentHomeBinding
import com.ripalay.store.domain.models.Brands
import com.ripalay.store.extensions.showToast
import com.ripalay.store.ui.catalogue.CatalogueAdapter
import com.ripalay.store.ui.promotions.PromotionsAdapter
import org.koin.androidx.viewmodel.ext.android.viewModel

class HomeFragment : BaseFragment<HomeViewModel, FragmentHomeBinding>(R.layout.fragment_home) {

    override val viewModel: HomeViewModel by viewModel()
    override val binding: FragmentHomeBinding by viewBinding()
    private lateinit var navController: NavController

    private var promotionList = mutableListOf<Results>()
    private lateinit var promotionsAdapter: PromotionsAdapter
    private lateinit var catalogueAdapter: CatalogueAdapter
    private lateinit var brandAdapter: BrandsAdapter

    override fun initObservers() {
        super.initObservers()
        viewModel.getCaps().observe(requireActivity()) {
            when (it.status) {
                Status.SUCCESS -> {
                    viewModel.loading.postValue(false)
                    val item = it.data
                    item?.results?.forEach {
                        if(it.newPrice == null){
                            promotionList.add(it)
                        }
                    }
                    promotionsAdapter = PromotionsAdapter(promotionList)
                    catalogueAdapter = CatalogueAdapter(item?.results!!, this::clickListener)
                    binding.recyclerCatalogue.adapter = catalogueAdapter
                }
                Status.LOADING -> {
                    viewModel.loading.postValue(true)
                }
            }
        }
        viewModel.getCapsBrand().observe(requireActivity()) {
            when (it.status) {
                Status.SUCCESS -> {
                    viewModel.loading.postValue(false)
                    val item = it.data
                    brandAdapter = BrandsAdapter(item!!.results, this::clickListenerBrand)
                    binding.recyclerBrands.adapter = brandAdapter
                }
            }
        }
    }

    private fun clickListenerBrand(result: ResultBrand) {
        val bundle = Bundle()
        bundle.putString("brandName", result.name)
        navController.navigate(R.id.capsByBrandFragment, bundle)
    }

    private fun clickListener(cap: Results) {
        val bundle = Bundle()
        bundle.putString("id", cap.id.toString())
        navController.navigate(R.id.detailCapsFragment, bundle)
    }



    override fun initViews() {
        binding.recyclerBrands.apply {
            layoutManager =
                LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        }

        binding.recyclerCatalogue.apply {
            layoutManager =
                LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        }

        binding.recyclerPromotions.apply {
            layoutManager =
                LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        }

        viewModel.loading.observe(this) {
            binding.progress.isVisible = it
        }
    }

    override fun initListeners() {
        binding.tvWatchCatalogue.setOnClickListener {
            navController.navigate(R.id.catalogueFragment)
        }

        binding.tvWatchPromotions.setOnClickListener {
            navController.navigate(R.id.catalogueFragment)
        }
    }

    override fun initNavController() {
        navController = findNavController()
    }

}