package com.dexciuq.effective_mobile.presentation.screen.catalog

import androidx.recyclerview.widget.DiffUtil
import com.dexciuq.effective_mobile.domain.model.Product

class ProductDiffUtil : DiffUtil.ItemCallback<Product>() {
    override fun areItemsTheSame(oldItem: Product, newItem: Product): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Product, newItem: Product): Boolean {
        return oldItem == newItem
    }
}