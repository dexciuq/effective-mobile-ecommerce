package com.dexciuq.effective_mobile.domain.usecase.user

import com.dexciuq.effective_mobile.domain.model.User
import com.dexciuq.effective_mobile.domain.repository.UserRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class RegisterUserUseCase @Inject constructor(
    private val userRepository: UserRepository
){
    suspend operator fun invoke(user: User) = withContext(Dispatchers.IO) {
        userRepository.register(user)
    }
}