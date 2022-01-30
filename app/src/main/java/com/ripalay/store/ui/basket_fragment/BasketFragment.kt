package com.ripalay.store.ui.basket_fragment

import androidx.fragment.app.viewModels
import by.kirich1409.viewbindingdelegate.viewBinding
import com.ripalay.store.R
import com.ripalay.store.core.ui.BaseFragment
import com.ripalay.store.core.ui.BaseViewModel
import com.ripalay.store.databinding.FragmentBasketBinding

class BasketFragment : BaseFragment<BaseViewModel,FragmentBasketBinding>(R.layout.fragment_basket) {

    override val viewModel: BaseViewModel by viewModels()
    override val binding: FragmentBasketBinding by viewBinding()

}