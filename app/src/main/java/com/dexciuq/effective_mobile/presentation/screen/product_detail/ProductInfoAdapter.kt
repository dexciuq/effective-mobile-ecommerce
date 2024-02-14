package com.dexciuq.effective_mobile.presentation.screen.product_detail

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.dexciuq.effective_mobile.databinding.ItemCharacteristicBinding
import com.dexciuq.effective_mobile.domain.model.ProductInfo

class ProductInfoAdapter : ListAdapter<ProductInfo, ProductInfoAdapter.ViewHolder>(ProductInfoDiffUtil()) {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ProductInfoAdapter.ViewHolder = ViewHolder(
        ItemCharacteristicBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
    )

    override fun onBindViewHolder(holder: ProductInfoAdapter.ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class ViewHolder(
        private val binding: ItemCharacteristicBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(productInfo: ProductInfo) {
            binding.key.text = productInfo.title
            binding.value.text = productInfo.value
        }
    }
}