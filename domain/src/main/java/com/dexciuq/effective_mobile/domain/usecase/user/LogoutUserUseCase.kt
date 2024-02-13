package com.dexciuq.effective_mobile.domain.usecase.user

import com.dexciuq.effective_mobile.domain.repository.UserRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class LogoutUserUseCase @Inject constructor(
    private val userRepository: UserRepository
) {
    suspend operator fun invoke() = withContext(Dispatchers.IO) {
        userRepository.logout()
    }
}