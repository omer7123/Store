package com.ripalay.store.ui.promotions

import androidx.fragment.app.viewModels
import by.kirich1409.viewbindingdelegate.viewBinding
import com.ripalay.store.R
import com.ripalay.store.core.ui.BaseFragment
import com.ripalay.store.core.ui.BaseViewModel
import com.ripalay.store.databinding.FragmentPromotionsBinding

class PromotionsFragment : BaseFragment<PromotionsViewModel, FragmentPromotionsBinding>(R.layout.fragment_promotions) {

    override val viewModel: PromotionsViewModel by viewModels()
    override val binding: FragmentPromotionsBinding by viewBinding()

}