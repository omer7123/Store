package com.ripalay.store.ui.catalogue

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.ripalay.store.databinding.ItemProductBinding
import com.ripalay.store.domain.models.CapProduct
import com.ripalay.store.domain.models.CapProductCallback

class CatalogueAdapter(private val list: List<CapProduct>)
    : ListAdapter<CapProduct, CatalogueAdapter.ViewHolder>(CapProductCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CatalogueAdapter.ViewHolder {
        val binding = ItemProductBinding.inflate(LayoutInflater.from(parent.context),
            parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CatalogueAdapter.ViewHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount(): Int {
        return list.size
    }

    inner class ViewHolder(itemBinding: ItemProductBinding) :
        RecyclerView.ViewHolder(itemBinding.root) {

        private val binding = itemBinding

        @SuppressLint("SetTextI18n")
        fun bind(product: CapProduct) {
            binding.tvBrandName.text = product.brand
            binding.tvProductName.text = product.name
            binding.tvPrice.text = "${product.price} сом"
        }
    }
}