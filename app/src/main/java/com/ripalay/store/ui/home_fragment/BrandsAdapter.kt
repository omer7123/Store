package com.ripalay.store.ui.home_fragment

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.ripalay.store.data.remote.models.ResultBrand
import com.ripalay.store.data.remote.models.Results
import com.ripalay.store.databinding.ItemBrandsBinding
import com.ripalay.store.domain.models.BrandsCallBack
import com.ripalay.store.extensions.load

class BrandsAdapter(
    private val list: List<ResultBrand>,
    private val clickListener: (result: ResultBrand) -> Unit
) :
    ListAdapter<ResultBrand, BrandsAdapter.ViewHolder>(BrandsCallBack()) {

    var onItemClick: ((Results) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BrandsAdapter.ViewHolder {
        val binding = ItemBrandsBinding.inflate(
            LayoutInflater.from(parent.context),
            parent, false
        )
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: BrandsAdapter.ViewHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount(): Int {
        return list.size
    }

    inner class ViewHolder(itemBinding: ItemBrandsBinding) :
        RecyclerView.ViewHolder(itemBinding.root) {

        private val binding = itemBinding

        fun bind(brand: ResultBrand) {
            binding.tvBrandName.text = brand.name
            binding.fabBrand.load(brand.icon)

            binding.root.setOnClickListener {
                clickListener(brand)
            }
        }
    }
}