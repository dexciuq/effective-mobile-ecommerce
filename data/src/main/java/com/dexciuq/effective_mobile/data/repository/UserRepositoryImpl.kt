package com.dexciuq.effective_mobile.data.repository

import com.dexciuq.effective_mobile.domain.model.User
import com.dexciuq.effective_mobile.domain.repository.UserRepository
import javax.inject.Inject

class UserRepositoryImpl @Inject constructor(

) : UserRepository {
    override suspend fun register(user: User) {
        TODO("Not yet implemented")
    }

    override suspend fun getUser(): User {
        TODO("Not yet implemented")
    }
}