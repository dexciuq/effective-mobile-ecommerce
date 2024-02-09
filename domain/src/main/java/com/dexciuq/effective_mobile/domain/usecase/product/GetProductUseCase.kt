package com.dexciuq.effective_mobile.domain.usecase.product

import com.dexciuq.effective_mobile.domain.repository.ProductRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class GetProductUseCase @Inject constructor(
    private val productRepository: ProductRepository
) {
    suspend operator fun invoke(id: String) = withContext(Dispatchers.IO) {
        productRepository.getProduct(id)
    }
}