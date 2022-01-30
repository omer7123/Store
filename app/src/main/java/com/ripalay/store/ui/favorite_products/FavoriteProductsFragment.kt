package com.ripalay.store.ui.favorite_products

import androidx.fragment.app.viewModels
import by.kirich1409.viewbindingdelegate.viewBinding
import com.ripalay.store.R
import com.ripalay.store.core.ui.BaseFragment
import com.ripalay.store.core.ui.BaseViewModel
import com.ripalay.store.databinding.FragmentFavoriteProductsBinding

class FavoriteProductsFragment : BaseFragment<BaseViewModel, FragmentFavoriteProductsBinding>
    (R.layout.fragment_favorite_products){

    override val viewModel: BaseViewModel by viewModels()
    override val binding: FragmentFavoriteProductsBinding by viewBinding()

}