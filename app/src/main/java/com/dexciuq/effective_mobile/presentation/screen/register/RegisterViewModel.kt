package com.dexciuq.effective_mobile.presentation.screen.register

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dexciuq.effective_mobile.domain.model.User
import com.dexciuq.effective_mobile.domain.usecase.user.GetAuthSkipUseCase
import com.dexciuq.effective_mobile.domain.usecase.user.RegisterUserUseCase
import com.dexciuq.effective_mobile.domain.usecase.user.SetAuthSkipUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RegisterViewModel @Inject constructor(
    private val getAuthSkipUseCase: GetAuthSkipUseCase,
    private val setAuthSkipUseCase: SetAuthSkipUseCase,
    private val registerUserUseCase: RegisterUserUseCase,
) : ViewModel() {

    private val _isLogged = MutableStateFlow(false)
    val isLogged = _isLogged.asStateFlow()

    init {
        getAuthSkip()
    }

    private fun getAuthSkip() = viewModelScope.launch {
        _isLogged.value = getAuthSkipUseCase()
    }

    fun register(user: User) = viewModelScope.launch {
        registerUserUseCase(user)
        setAuthSkipUseCase(true)
        _isLogged.value = getAuthSkipUseCase()
    }
}