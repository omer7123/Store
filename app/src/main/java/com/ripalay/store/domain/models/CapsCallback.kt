package com.ripalay.store.domain.models

import androidx.recyclerview.widget.DiffUtil
import com.ripalay.store.data.remote.models.Results

class CapsCallback: DiffUtil.ItemCallback<Results> () {

    override fun areItemsTheSame(oldItem: Results, newItem: Results): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Results, newItem: Results): Boolean {
        return oldItem == newItem
    }
}