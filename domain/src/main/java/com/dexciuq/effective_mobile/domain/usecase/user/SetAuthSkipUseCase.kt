package com.dexciuq.effective_mobile.domain.usecase.user

import com.dexciuq.effective_mobile.domain.repository.UserRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class SetAuthSkipUseCase @Inject constructor(
    private val userRepository: UserRepository
) {
    suspend operator fun invoke(skip: Boolean) = withContext(Dispatchers.IO) {
        userRepository.setAuthSkip(skip)
    }
}