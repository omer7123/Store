package com.ripalay.store.ui.catalogue

import android.util.Log
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.ripalay.store.R
import com.ripalay.store.core.network.result.Status
import com.ripalay.store.core.ui.BaseFragment
import com.ripalay.store.databinding.FragmentCatalogueBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class CatalogueFragment :
    BaseFragment<CatalogueViewModel, FragmentCatalogueBinding>(R.layout.fragment_catalogue) {

    override val viewModel: CatalogueViewModel by viewModel()
    override val binding: FragmentCatalogueBinding by viewBinding()

    override fun initViews() {
        super.initViews()
        binding.recyclerCatalogue.apply {
            layoutManager = GridLayoutManager(requireContext(),2)
        }

    }
    override fun initObservers() {
        super.initObservers()
        viewModel.getCaps().observe(this) {
            when(it.status){
                Status.SUCCESS ->{
                    var item = it.data
                    val adapter = CatalogueAdapter(item?.results!!)
                    binding.recyclerCatalogue.adapter = adapter
                    Log.e("ololo",item.toString())
                }
            }
        }
    }
}