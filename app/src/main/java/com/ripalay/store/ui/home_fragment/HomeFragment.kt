package com.ripalay.store.ui.home_fragment

import androidx.fragment.app.viewModels
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.ripalay.store.R
import com.ripalay.store.core.ui.BaseFragment
import com.ripalay.store.data.local.prefs.Prefs
import com.ripalay.store.data.remote.models.Results
import com.ripalay.store.databinding.FragmentHomeBinding
import com.ripalay.store.domain.models.Brands
import com.ripalay.store.extensions.showToast
import com.ripalay.store.ui.catalogue.CatalogueAdapter
import com.ripalay.store.ui.promotions.PromotionsAdapter

class HomeFragment : BaseFragment<HomeViewModel, FragmentHomeBinding>(R.layout.fragment_home) {

    override val viewModel: HomeViewModel by viewModels()
    override val binding: FragmentHomeBinding by viewBinding()
    private lateinit var navController: NavController

    private var productList = mutableListOf<Results>()
    private var brandsList = mutableListOf<Brands>()
    private val catalogueAdapter: CatalogueAdapter by lazy {
        CatalogueAdapter(productList, this::clickListener)
    }

    override fun initObservers() {
        super.initObservers()

    }
    private fun clickListener(productList: Results) {

    }

    private val promotionsAdapter: PromotionsAdapter by lazy {
        PromotionsAdapter(productList)
    }

    private val brandsAdapter: BrandsAdapter by lazy {
        BrandsAdapter(brandsList)
    }

    override fun initViews() {
        binding.recyclerBrands.apply {
            layoutManager =
                LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
            adapter = this@HomeFragment.brandsAdapter
        }

        binding.recyclerCatalogue.apply {
            layoutManager =
                LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
            adapter = this@HomeFragment.catalogueAdapter
        }

        binding.recyclerPromotions.apply {
            layoutManager =
                LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
            adapter = this@HomeFragment.promotionsAdapter
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