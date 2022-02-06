package com.ripalay.store.domain.models

import androidx.recyclerview.widget.DiffUtil

class CapProductCallback: DiffUtil.ItemCallback<CapProduct> () {

    override fun areItemsTheSame(oldItem: CapProduct, newItem: CapProduct): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: CapProduct, newItem: CapProduct): Boolean {
        return oldItem == newItem
    }
}