package com.dexciuq.effective_mobile.presentation.screen.profile

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dexciuq.effective_mobile.R
import com.dexciuq.effective_mobile.common.Resource
import com.dexciuq.effective_mobile.domain.usecase.product.GetProductListUseCase
import com.dexciuq.effective_mobile.domain.usecase.user.GetUserUseCase
import com.dexciuq.effective_mobile.domain.usecase.user.LogoutUserUseCase
import com.dexciuq.effective_mobile.domain.usecase.user.SetAuthSkipUseCase
import com.dexciuq.effective_mobile.presentation.screen.profile.ProfileAdapterModel.MenuInfo
import com.dexciuq.effective_mobile.presentation.screen.profile.ProfileAdapterModel.ProfileInfo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProfileViewModel @Inject constructor(
    private val getUserUseCase: GetUserUseCase,
    private val logoutUserUseCase: LogoutUserUseCase,
    private val setAuthSkipUseCase: SetAuthSkipUseCase,
) : ViewModel() {

    private val _profile = MutableStateFlow<Resource<List<ProfileAdapterModel>>>(Resource.Loading)
    val profile = _profile.asStateFlow()

    fun getProfile() = viewModelScope.launch {
        val profileAdapterModels = mutableListOf<ProfileAdapterModel>()
        val user = getUserUseCase()

        profileAdapterModels.add(
            ProfileInfo(
                icon = R.drawable.ic_profile,
                title = "${user.name} ${user.surname}",
                description = user.phoneNumber,
                endIcon = R.drawable.ic_logout,
            )
        )

        profileAdapterModels.add(
            ProfileInfo(
                icon = R.drawable.ic_love,
                title = "Избранное",
                description = "1 товар",
                endIcon = R.drawable.ic_next
            )
        )

        profileAdapterModels.addAll(
            listOf(
                MenuInfo(R.drawable.ic_stores, "Магазины"),
                MenuInfo(R.drawable.ic_feedback, "Обратная связь"),
                MenuInfo(R.drawable.ic_offer, "Оферта"),
                MenuInfo(R.drawable.ic_rollback, "Возврат товара")
            )
        )

        _profile.value = Resource.Success(profileAdapterModels)
    }

    fun logout() = viewModelScope.launch {
        setAuthSkipUseCase(false)
        logoutUserUseCase()
    }
}