package com.dexciuq.effective_mobile.presentation.screen.product_detail

import com.dexciuq.effective_mobile.domain.model.Product

sealed class ProductDetailsAdapterModel {
    data class Information(
        val product: Product,
    ) : ProductDetailsAdapterModel()

    data class Description(
        val product: Product,
    ) : ProductDetailsAdapterModel()

    data class Characteristics(
        val product: Product,
    ) : ProductDetailsAdapterModel()

    data class Ingredients(
        val product: Product,
    ) : ProductDetailsAdapterModel()
}