package com.ripalay.store.ui.catalogue

import android.annotation.SuppressLint
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.ripalay.store.R
import com.ripalay.store.data.remote.models.Result
import com.ripalay.store.databinding.ItemProductBinding
import com.ripalay.store.domain.models.CapsCallback
import com.ripalay.store.extensions.load
import org.koin.core.KoinApplication.Companion.init


class CatalogueAdapter(
    private val list: List<Result>,
    private val clickListener: (result: Result) -> Unit
) :
    ListAdapter<Result, CatalogueAdapter.ViewHolder>(CapsCallback()) {

    var onItemClick: ((Result) -> Unit)? = null

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
        fun bind(result: Result) {
            binding.tvBrandName.text = result.brand.toString()
            binding.tvProductName.text = result.name
            binding.ivProduct.load(result.image.toString())
            binding.tvPrice.text = "${result.price} сом"
            binding.root.setOnClickListener {
                clickListener(result)
            }
            binding.ivLike.setOnClickListener {
                //   Log.e("test", binding.ivLike.resources.getString(R.drawable.ic_like_selected).toString())
//                if (binding.ivLike.drawable.toString() ==
//                    "android.graphics.drawable.VectorDrawable@6fc5de0"
//                    || binding.ivLike.drawable.toString() ==
//                    "android.graphics.drawable.VectorDrawable@6fc5de0"
//                ) {
                    binding.ivLike.setImageResource(R.drawable.ic_like_selected)
//                }
                // clickListener(result)
            }
        }
        init {
            binding.ivLike.setOnClickListener {
                binding.ivLike.setImageResource(R.drawable.ic_like_selected)
                onItemClick?.invoke(list[absoluteAdapterPosition])
            }
        }
    }
}