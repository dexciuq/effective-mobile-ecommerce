package com.dexciuq.effective_mobile.presentation.screen.product_detail

import com.dexciuq.effective_mobile.domain.model.Product

sealed class ProductDetailsAdapterModel {
    data class Information(
        val product: Product,
    ) : ProductDetailsAdapterModel()

    data class Description(
        private val product: Product,
    ) : ProductDetailsAdapterModel()

    data class Characteristics(
        private val product: Product,
    ) : ProductDetailsAdapterModel()

    data class Ingredients(
        private val product: Product,
    ) : ProductDetailsAdapterModel()

    data class BuyButton(
        private val product: Product,
    ) : ProductDetailsAdapterModel()
}