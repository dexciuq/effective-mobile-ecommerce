package com.dexciuq.effective_mobile.presentation.screen.product_detail

import androidx.recyclerview.widget.DiffUtil
import com.dexciuq.effective_mobile.domain.model.ProductInfo

class ProductInfoDiffUtil : DiffUtil.ItemCallback<ProductInfo>() {
    override fun areItemsTheSame(oldItem: ProductInfo, newItem: ProductInfo): Boolean {
        return oldItem.title == newItem.title
    }

    override fun areContentsTheSame(oldItem: ProductInfo, newItem: ProductInfo): Boolean {
        return oldItem == newItem
    }
}