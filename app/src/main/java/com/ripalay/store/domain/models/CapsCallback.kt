package com.ripalay.store.domain.models

import androidx.recyclerview.widget.DiffUtil
import com.ripalay.store.data.remote.models.Result

class CapsCallback: DiffUtil.ItemCallback<Result> () {

    override fun areItemsTheSame(oldItem: Result, newItem: Result): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Result, newItem: Result): Boolean {
        return oldItem == newItem
    }
}