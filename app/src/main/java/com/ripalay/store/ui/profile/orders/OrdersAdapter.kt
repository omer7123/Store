package com.ripalay.store.ui.account_fragment.orders

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.ripalay.store.databinding.ItemOrdersBinding
import com.ripalay.store.data.remote.models.Order
import com.ripalay.store.domain.models.OrdersCallBack

class OrdersAdapter(
    private val list: List<Order>, private val clickListener: (order: Order) -> Unit,
) :
    ListAdapter<Order, OrdersAdapter.ViewHolder>(OrdersCallBack()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OrdersAdapter.ViewHolder {
        val binding = ItemOrdersBinding.inflate(
            LayoutInflater.from(parent.context),
            parent, false
        )
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: OrdersAdapter.ViewHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount(): Int {
        return list.size
    }

    inner class ViewHolder(itemBinding: ItemOrdersBinding) :
        RecyclerView.ViewHolder(itemBinding.root) {

        private val binding = itemBinding

        fun bind(order: Order) {

            binding.tvId.text = order.id.toString()
            binding.tvDate.text = order.date
            binding.tvStatus.text = order.status

            binding.root.setOnClickListener {
                clickListener(order)
            }
        }
    }
}