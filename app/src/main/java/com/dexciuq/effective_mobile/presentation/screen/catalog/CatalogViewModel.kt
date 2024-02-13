package com.dexciuq.effective_mobile.presentation.screen.catalog

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dexciuq.effective_mobile.common.Resource
import com.dexciuq.effective_mobile.domain.model.Product
import com.dexciuq.effective_mobile.domain.usecase.product.GetProductListUseCase
import com.dexciuq.effective_mobile.presentation.screen.catalog.filter.Sort
import com.dexciuq.effective_mobile.presentation.screen.catalog.filter.Tag
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CatalogViewModel @Inject constructor(
    private val getProductListUseCase: GetProductListUseCase
) : ViewModel() {

    private lateinit var initList: List<Product>

    private val _products = MutableStateFlow<Resource<List<Product>>>(Resource.Loading)
    val products = _products.asStateFlow()

    init {
        getProductList()
    }

    private fun getProductList() = viewModelScope.launch {
        getProductListUseCase().collectLatest {
            if (it is Resource.Success) {
                initList = it.data
                filter(Sort.POPULAR, Tag.ALL)
            } else {
                _products.value = it
            }
        }
    }

    fun filter(sort: Sort, tag: Tag) {
        _products.value = Resource.Loading

        var result = if (tag == Tag.ALL) {
            initList
        } else {
            initList.filter {
                it.tags.contains(tag.name.lowercase())
            }
        }

        result = when (sort) {
            Sort.POPULAR -> {
                result.sortedByDescending { it.feedback.rating }
            }

            Sort.HIGH_TO_LOW -> {
                result.sortedByDescending { it.price.priceWithDiscount.toInt() }
            }

            Sort.LOW_TO_HIGH -> {
                result.sortedBy { it.price.priceWithDiscount.toInt() }
            }
        }

        _products.value = Resource.Success(result)
    }
}