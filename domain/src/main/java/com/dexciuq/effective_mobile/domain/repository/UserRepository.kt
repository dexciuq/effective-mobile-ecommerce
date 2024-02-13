package com.dexciuq.effective_mobile.domain.repository

import com.dexciuq.effective_mobile.domain.model.User

interface UserRepository {
    suspend fun getAuthSkip(): Boolean
    suspend fun setAuthSkip(skip: Boolean)
    suspend fun register(user: User)
    suspend fun getUser(): User
    suspend fun logout()
}