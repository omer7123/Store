package com.ripalay.store.domain.models

import androidx.recyclerview.widget.DiffUtil

class BrandsCallBack : DiffUtil.ItemCallback<Brands> () {

    override fun areItemsTheSame(oldItem: Brands, newItem: Brands): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Brands, newItem: Brands): Boolean {
        return oldItem == newItem
    }
}