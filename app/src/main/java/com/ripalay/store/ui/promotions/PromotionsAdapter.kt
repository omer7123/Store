package com.ripalay.store.ui.promotions

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.ripalay.store.databinding.ItemProductPromotionBinding
import com.ripalay.store.domain.models.CapProduct
import com.ripalay.store.domain.models.CapProductCallback

class PromotionsAdapter (private val list: List<CapProduct>)
    : ListAdapter<CapProduct, PromotionsAdapter.ViewHolder>(CapProductCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PromotionsAdapter.ViewHolder {
        val binding = ItemProductPromotionBinding.inflate(LayoutInflater.from(parent.context),
            parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PromotionsAdapter.ViewHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount(): Int {
        return list.size
    }

    inner class ViewHolder(itemBinding: ItemProductPromotionBinding) :
        RecyclerView.ViewHolder(itemBinding.root) {

        private val binding = itemBinding

        @SuppressLint("SetTextI18n")
        fun bind(product: CapProduct) {
            binding.tvBrandName.text = product.brand
            binding.tvProductName.text = product.name
            binding.tvNewPrice.text = "${product.price} сом"
            binding.tvOldPrice.text = "${product.oldPrice} сом"
        }
    }
}