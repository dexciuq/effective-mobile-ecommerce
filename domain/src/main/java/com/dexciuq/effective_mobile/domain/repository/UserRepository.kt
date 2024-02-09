package com.dexciuq.effective_mobile.domain.repository

import com.dexciuq.effective_mobile.domain.model.User

interface UserRepository {
    suspend fun register(user: User)
    suspend fun getUser(): User
}