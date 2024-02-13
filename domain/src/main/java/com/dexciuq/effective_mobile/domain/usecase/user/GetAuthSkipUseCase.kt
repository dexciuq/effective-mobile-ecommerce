package com.dexciuq.effective_mobile.domain.usecase.user

import com.dexciuq.effective_mobile.domain.repository.UserRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class GetAuthSkipUseCase @Inject constructor(
    private val userRepository: UserRepository
) {
    suspend operator fun invoke(): Boolean = withContext(Dispatchers.IO) {
        userRepository.getAuthSkip()
    }
}