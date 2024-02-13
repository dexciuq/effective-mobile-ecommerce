package com.dexciuq.effective_mobile.presentation.screen.product_detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dexciuq.effective_mobile.common.Resource
import com.dexciuq.effective_mobile.domain.model.Product
import com.dexciuq.effective_mobile.domain.usecase.product.AddToFavoritesUseCase
import com.dexciuq.effective_mobile.domain.usecase.product.GetProductUseCase
import com.dexciuq.effective_mobile.domain.usecase.product.RemoveFromFavoritesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProductDetailsViewModel @Inject constructor(
    private val addToFavoritesUseCase: AddToFavoritesUseCase,
    private val removeFromFavoritesUseCase: RemoveFromFavoritesUseCase,
) : ViewModel() {

    private val _productInfoList = MutableStateFlow<Resource<List<ProductDetailsAdapterModel>>>(Resource.Loading)
    val productInfo = _productInfoList.asStateFlow()

    fun getProductInfo(product: Product) = viewModelScope.launch {
        val result = mutableListOf<ProductDetailsAdapterModel>()

        result.add(ProductDetailsAdapterModel.Information(product))

        _productInfoList.value = Resource.Success(result)
    }

    fun addToFavorites(product: Product) = viewModelScope.launch {
        addToFavoritesUseCase(product)
    }

    fun removeFromFavorites(product: Product) = viewModelScope.launch {
        removeFromFavoritesUseCase(product)
    }
}