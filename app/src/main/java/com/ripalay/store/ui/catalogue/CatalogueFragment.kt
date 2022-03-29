package com.ripalay.store.ui.catalogue

import android.os.Bundle
import android.util.Log
import androidx.core.view.isVisible
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.ripalay.store.R
import com.ripalay.store.core.network.result.Status
import com.ripalay.store.core.ui.BaseFragment
import com.ripalay.store.data.remote.models.Results
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
        viewModel.getCaps().observe(this){
            Log.e("oloo", it.data.toString())
        }
        viewModel.getCaps().observe(this) {
            when (it.status) {
                Status.SUCCESS -> {
                    Log.e("plpo", it.data.toString())
                    val item = it.data
                    adapter = CatalogueAdapter(
                        item?.results!!,
                        this::clickListener
                    )
                    binding.recyclerCatalogue.adapter = adapter
                    viewModel.loading.postValue(false)
                }
                Status.LOADING -> {
                    Log.e("ololo", "Loading")
                    viewModel.loading.postValue(true)
                }
            }
        }
    }

    private fun clickListener(result: Results) {
        val bundle = Bundle()
        bundle.putString("id", result.id.toString())
        navController.navigate(R.id.detailCapsFragment, bundle)
        adapter.onItemClick = {
            if (result.isFavorite) {
                Log.e("ololo", it.toString())
                //Отправляем на бэк модель
            } else {
                //Удаляем модель с бэка
            }
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