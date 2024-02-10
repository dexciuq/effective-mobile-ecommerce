package com.dexciuq.effective_mobile.data.mapper

import com.dexciuq.effective_mobile.data.model.remote.ProductDto
import com.dexciuq.effective_mobile.data.model.remote.ProductFeedbackDto
import com.dexciuq.effective_mobile.data.model.remote.ProductInfoDto
import com.dexciuq.effective_mobile.data.model.remote.ProductPriceDto
import com.dexciuq.effective_mobile.domain.model.Product
import com.dexciuq.effective_mobile.domain.model.ProductFeedback
import com.dexciuq.effective_mobile.domain.model.ProductInfo
import com.dexciuq.effective_mobile.domain.model.ProductPrice

internal fun ProductDto.toDomain(): Product = Product(
    id = id,
    title = title,
    subtitle = subtitle,
    price = price.toDomain(),
    feedback = feedback.toDomain(),
    tags = tags,
    available = available,
    description = description,
    info = info.map(ProductInfoDto::toDomain),
    ingredients = ingredients,
)

private fun ProductPriceDto.toDomain(): ProductPrice = ProductPrice(
    price = price,
    discount = discount,
    priceWithDiscount = priceWithDiscount,
    unit = unit,
)

private fun ProductFeedbackDto.toDomain(): ProductFeedback = ProductFeedback(
    count = count,
    rating = rating
)

private fun ProductInfoDto.toDomain(): ProductInfo = ProductInfo(
    title = title,
    value = value,
)