package com.ripalay.store.domain.models

import android.annotation.SuppressLint
import androidx.recyclerview.widget.DiffUtil
import com.ripalay.store.data.remote.models.Order

class OrdersCallBack: DiffUtil.ItemCallback<Order> () {

    override fun areItemsTheSame(oldItem: Order, newItem: Order): Boolean {
        return oldItem.id == newItem.id
    }

    @SuppressLint("DiffUtilEquals")
    override fun areContentsTheSame(oldItem: Order, newItem: Order): Boolean {
        return oldItem == newItem
    }

}