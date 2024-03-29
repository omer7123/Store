package com.ripalay.store.ui.detail_caps_fragment

import android.annotation.SuppressLint
import android.util.Log
import androidx.lifecycle.viewModelScope
import by.kirich1409.viewbindingdelegate.viewBinding
import com.ripalay.store.App
import com.ripalay.store.R
import com.ripalay.store.core.network.result.Status
import com.ripalay.store.core.ui.BaseFragment
import com.ripalay.store.data.remote.models.Results
import com.ripalay.store.databinding.FragmentDetailCapsBinding
import com.ripalay.store.extensions.load
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel

class DetailCapsFragment :
    BaseFragment<DetailCapsViewModel, FragmentDetailCapsBinding>(R.layout.fragment_detail_caps) {

    override val viewModel: DetailCapsViewModel by viewModel()
    override val binding: FragmentDetailCapsBinding by viewBinding()

    override fun initObservers() {
        super.initObservers()
        val bundle = arguments
        viewModel.getCapId(bundle?.getString("id").toString()).observe(this) {
            when (it.status) {
                Status.SUCCESS -> {
                    val item = it.data
                    Log.e("ololo", item.toString())
                    updateView(item)
                }
                Status.LOADING->{
                    Log.e("LOADING DEETAIL","YS")
                }
            }
        }
    }

    @SuppressLint("SetTextI18n")
    private fun updateView(item: Results?) {
        binding.brandNameTv.text = item?.brand.toString()
        binding.describeTv.text = item?.description.toString()
        binding.imageIv.load(item!!.capsImage[0]!!.image)
        binding.nameCapTv.text = item.name.toString()
        binding.priceTv.text = "${item.price} сом"
//        Log.e("ololo", item?.capsImage.toString())
    }
}