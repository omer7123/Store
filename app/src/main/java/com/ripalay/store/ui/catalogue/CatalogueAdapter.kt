package com.ripalay.store.ui.catalogue

import android.annotation.SuppressLint
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.ripalay.store.R
import com.ripalay.store.data.remote.models.Results
import com.ripalay.store.databinding.ItemProductBinding
import com.ripalay.store.domain.models.CapsCallback
import com.ripalay.store.extensions.load


class CatalogueAdapter(
    private val list: List<Results>,
    private val clickListener: (result: Results) -> Unit
) :
    ListAdapter<Results, CatalogueAdapter.ViewHolder>(CapsCallback()) {

    var onItemClick: ((Results) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CatalogueAdapter.ViewHolder {
        val binding = ItemProductBinding.inflate(
            LayoutInflater.from(parent.context),
            parent, false
        )
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
        // val int = Re
        //  var d: Drawable = Resources(android.R.drawable.ic_dialog_email)

        @SuppressLint("SetTextI18n", "ResourceType")
        fun bind(result: Results) {
            binding.tvBrandName.text = result.brand.toString()
            binding.tvProductName.text = result.name
//            binding.ivProduct.load(result.capsImage.toString())
            binding.tvPrice.text = "${result.price} сом"
            binding.ivLike.setOnClickListener {
                result.isFavorite = !result.isFavorite
                if (result.isFavorite) {
                    binding.ivLike.setImageResource(R.drawable.ic_like_selected)
                }
                if (!result.isFavorite) {
                    binding.ivLike.setImageResource(R.drawable.ic_like)
                }
                onItemClick?.invoke(list[absoluteAdapterPosition])
                Log.e("olol", "test")
            }
            binding.root.setOnClickListener {
                clickListener(result)
            }
        }
    }
}