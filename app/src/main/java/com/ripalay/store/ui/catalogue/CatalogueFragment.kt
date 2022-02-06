package com.ripalay.store.ui.catalogue

import androidx.fragment.app.viewModels
import by.kirich1409.viewbindingdelegate.viewBinding
import com.ripalay.store.R
import com.ripalay.store.core.ui.BaseFragment
import com.ripalay.store.core.ui.BaseViewModel
import com.ripalay.store.databinding.FragmentCatalogueBinding

class CatalogueFragment : BaseFragment<CatalogueViewModel, FragmentCatalogueBinding>(R.layout.fragment_catalogue) {

    override val viewModel: CatalogueViewModel by viewModels()
    override val binding: FragmentCatalogueBinding by viewBinding()

}