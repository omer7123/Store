package com.ripalay.store.ui.catalogue

import android.util.Log
import androidx.fragment.app.viewModels
import by.kirich1409.viewbindingdelegate.viewBinding
import com.ripalay.store.R
import com.ripalay.store.core.network.result.Status
import com.ripalay.store.core.ui.BaseFragment
import com.ripalay.store.databinding.FragmentCatalogueBinding

class CatalogueFragment :
    BaseFragment<CatalogueViewModel, FragmentCatalogueBinding>(R.layout.fragment_catalogue) {

    override val viewModel: CatalogueViewModel by viewModels()
    override val binding: FragmentCatalogueBinding by viewBinding()

    override fun initObservers() {
        super.initObservers()
        viewModel.getCaps().observe(this) {
            when(it.status){
                Status.SUCCESS ->{
                    var item = it
                    Log.e("ololo",item.toString())
                }
            }
        }
    }

    override fun initViews() {
        super.initViews()
    }

    override fun initListeners() {
        super.initListeners()
    }

    override fun initNavController() {
        super.initNavController()
    }
}