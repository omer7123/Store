package com.ripalay.store.ui.detail_caps_fragment

import android.util.Log
import by.kirich1409.viewbindingdelegate.viewBinding
import com.ripalay.store.R
import com.ripalay.store.core.network.result.Status
import com.ripalay.store.core.ui.BaseFragment
import com.ripalay.store.data.remote.models.Results
import com.ripalay.store.databinding.FragmentDetailCapsBinding
import com.ripalay.store.extensions.load
import org.koin.androidx.viewmodel.ext.android.viewModel

class DetailCapsFragment :
    BaseFragment<DetailCapsViewModel, FragmentDetailCapsBinding>(R.layout.fragment_detail_caps) {

    override val viewModel: DetailCapsViewModel by viewModel()
    override val binding: FragmentDetailCapsBinding by viewBinding()

    override fun initObservers() {
        super.initObservers()
        val bundle = arguments
        bundle?.getString("id")
        viewModel.getCapId(bundle?.getString("id").toString()).observe(this) {
            when (it.status) {
                Status.SUCCESS -> {
                    val item = it.data?.results?.get(0)
                    updateView(item)
                }
            }
        }
    }

    private fun updateView(item: Results?) {
        binding.describeTv.text = item?.description.toString()
        binding.imageIv.load(item!!.capsImage.toString())
        binding.nameCapTv.text = item.name.toString()
        binding.priceTv.text = item.price.toString()
        Log.e("ololo", item.capsImage.toString())
    }
}