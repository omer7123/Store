package com.ripalay.store.domain.models

import androidx.recyclerview.widget.DiffUtil
import com.ripalay.store.data.remote.models.ResultBrand

class BrandsCallBack : DiffUtil.ItemCallback<ResultBrand> () {

    override fun areItemsTheSame(oldItem: ResultBrand, newItem: ResultBrand): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: ResultBrand, newItem: ResultBrand): Boolean {
        return oldItem == newItem
    }
}