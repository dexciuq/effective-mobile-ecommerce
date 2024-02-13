package com.dexciuq.effective_mobile.presentation.screen.catalog

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.dexciuq.effective_mobile.R
import com.dexciuq.effective_mobile.databinding.ItemProductBinding
import com.dexciuq.effective_mobile.domain.model.Product
import com.dexciuq.effective_mobile.presentation.screen.picture.PictureViewPagerAdapter
import com.dexciuq.effective_mobile.presentation.utils.getImageById
import com.google.android.material.tabs.TabLayoutMediator

class ProductAdapter(
    private val fragmentActivity: FragmentActivity,
    private val onItemClick: (Product) -> Unit = {},
    private val onLikeClick: (Product) -> Unit = {},
    private val onUnlikeClick: (Product) -> Unit = {},
) : ListAdapter<Product, ProductAdapter.ViewHolder>(ProductDiffUtil()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder(
        ItemProductBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
    )

    override fun onBindViewHolder(holder: ViewHolder, position: Int) =
        holder.bind(getItem(position))

    inner class ViewHolder(
        private val binding: ItemProductBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        @SuppressLint("SetTextI18n")
        fun bind(product: Product) {
            val adapter = PictureViewPagerAdapter(fragmentActivity, product.id.getImageById())
            binding.image.adapter = adapter
            binding.image.offscreenPageLimit = 1

            TabLayoutMediator(binding.tabLayout, binding.image) { _, _ -> }.attach()

            binding.title.text = product.title
            binding.description.text = product.subtitle

            binding.discountPercent.text = product.price.discount.toDiscountPercent()
            binding.price.text = product.price.price.toMoney(product.price.unit)
            binding.priceWithoutDiscount.text =
                product.price.priceWithDiscount.toMoney(product.price.unit)

            binding.rating.text = product.feedback.rating.toString()
            binding.count.text = product.feedback.count.toCount()

            binding.like.setOnClickListener {
                binding.like.setImageResource(R.drawable.ic_love_filled)
            }

            binding.root.setOnClickListener { onItemClick(product) }
        }

        private fun Int.toCount() = "($this)"

        private fun String.toMoney(unit: String) = "$this $unit"

        private fun Int.toDiscountPercent() = "-$this%"
    }
}