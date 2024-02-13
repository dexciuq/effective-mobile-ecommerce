package com.dexciuq.effective_mobile.presentation.screen.product_detail

import androidx.fragment.app.FragmentActivity
import com.dexciuq.effective_mobile.R
import com.dexciuq.effective_mobile.databinding.ItemProductInformationBinding
import com.dexciuq.effective_mobile.domain.model.Product
import com.dexciuq.effective_mobile.presentation.screen.picture.PictureViewPagerAdapter
import com.dexciuq.effective_mobile.presentation.utils.getImageById
import com.dexciuq.effective_mobile.presentation.utils.toCountFeedback
import com.dexciuq.effective_mobile.presentation.utils.toDiscountPercent
import com.dexciuq.effective_mobile.presentation.utils.toMoney
import com.google.android.material.tabs.TabLayoutMediator
import com.hannesdorfmann.adapterdelegates4.ListDelegationAdapter
import com.hannesdorfmann.adapterdelegates4.dsl.adapterDelegateViewBinding

class ProductDetailsAdapter(
    fragmentActivity: FragmentActivity,
    onLikeClick: (Product) -> Unit = {},
    onUnlikeClick: (Product) -> Unit = {},
) : ListDelegationAdapter<List<ProductDetailsAdapterModel>>(
    informationAdapterDelegate(fragmentActivity, onLikeClick, onUnlikeClick)
)

private fun informationAdapterDelegate(
    fragmentActivity: FragmentActivity,
    onLikeClick: (Product) -> Unit = {},
    onUnlikeClick: (Product) -> Unit = {},
) =
    adapterDelegateViewBinding<ProductDetailsAdapterModel.Information, ProductDetailsAdapterModel, ItemProductInformationBinding>(
        { layoutInflater, root ->
            ItemProductInformationBinding.inflate(
                layoutInflater,
                root,
                false
            )
        }
    ) {
        bind {
            with(item) {
                val adapter = PictureViewPagerAdapter(fragmentActivity, product.id.getImageById())
                binding.image.adapter = adapter
                binding.image.offscreenPageLimit = 1

                TabLayoutMediator(binding.tabLayout, binding.image) { _, _ -> }.attach()

                binding.title.text = product.title
                binding.subtitle.text = product.subtitle

                binding.discountPercent.text = product.price.discount.toDiscountPercent()
                binding.price.text = product.price.price.toMoney(product.price.unit)
                binding.priceWithoutDiscount.text =
                    product.price.priceWithDiscount.toMoney(product.price.unit)


                binding.availability.text = "Доступно для заказа ${product.available} штук"

                binding.feedback.text =
                    "${product.feedback.rating} • ${product.feedback.count.toCountFeedback()}"

                if (product.liked) {
                    binding.like.setImageResource(R.drawable.ic_love_filled)
                } else {
                    binding.like.setImageResource(R.drawable.ic_love)
                }

                binding.like.setOnClickListener {
                    if (product.liked) {
                        product.liked = false
                        onUnlikeClick(product)
                        binding.like.setImageResource(R.drawable.ic_love)
                    } else {
                        product.liked = true
                        onLikeClick(product)
                        binding.like.setImageResource(R.drawable.ic_love_filled)
                    }
                }
            }
        }
    }