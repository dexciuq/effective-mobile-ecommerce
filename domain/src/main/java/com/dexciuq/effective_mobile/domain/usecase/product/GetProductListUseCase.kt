package com.dexciuq.effective_mobile.domain.usecase.product

import com.dexciuq.effective_mobile.domain.repository.ProductRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class GetProductListUseCase @Inject constructor(
    private val productRepository: ProductRepository
) {
    suspend operator fun invoke() = withContext(Dispatchers.IO) {
        productRepository.getProductList()
    }
}