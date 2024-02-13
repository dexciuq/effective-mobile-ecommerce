package com.dexciuq.effective_mobile.presentation.screen.favorites

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dexciuq.effective_mobile.common.Resource
import com.dexciuq.effective_mobile.domain.model.Product
import com.dexciuq.effective_mobile.domain.usecase.product.AddToFavoritesUseCase
import com.dexciuq.effective_mobile.domain.usecase.product.GetFavoriteListUseCase
import com.dexciuq.effective_mobile.domain.usecase.product.RemoveFromFavoritesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FavoritesViewModel @Inject constructor(
    private val getFavoriteListUseCase: GetFavoriteListUseCase,
    private val addToFavoritesUseCase: AddToFavoritesUseCase,
    private val removeFromFavoritesUseCase: RemoveFromFavoritesUseCase,
) : ViewModel() {

    private val _favorites = MutableStateFlow<Resource<List<Product>>>(Resource.Loading)
    val favorites = _favorites.asStateFlow()

    init {
        getFavoriteList()
    }

    private fun getFavoriteList() = viewModelScope.launch {
        getFavoriteListUseCase().collectLatest {
            _favorites.value = it
        }
    }

    fun addToFavorites(product: Product) = viewModelScope.launch {
        addToFavoritesUseCase(product)
    }

    fun removeFromFavorites(product: Product) = viewModelScope.launch {
        removeFromFavoritesUseCase(product)
    }

}