package com.ripalay.store.ui.promotions

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.ripalay.store.data.remote.models.Results
import com.ripalay.store.databinding.ItemProductPromotionBinding
import com.ripalay.store.domain.models.CapsCallback
import com.ripalay.store.extensions.load

class PromotionsAdapter (private val list: List<Results>)
    : ListAdapter<Results, PromotionsAdapter.ViewHolder>(CapsCallback()) {

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
        fun bind(result: Results) {
            binding.ivProduct.load(result.capsImage[0].toString())
            binding.tvBrandName.text = result.brand.toString()
            binding.tvProductName.text = result.name
            binding.tvNewPrice.text = "${result.newPrice} сом"
            binding.tvOldPrice.text = "${result.price} сом"
//            binding.tvOldPrice.text = "${product.oldPrice} сом"
        }
    }
}