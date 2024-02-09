package com.dexciuq.effective_mobile.domain.usecase.product

import com.dexciuq.effective_mobile.domain.model.Product
import com.dexciuq.effective_mobile.domain.repository.ProductRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class RemoveFromFavoritesUseCase @Inject constructor(
    private val productRepository: ProductRepository
) {
    suspend operator fun invoke(product: Product) = withContext(Dispatchers.IO) {
        productRepository.removeFromFavorites(product)
    }
}