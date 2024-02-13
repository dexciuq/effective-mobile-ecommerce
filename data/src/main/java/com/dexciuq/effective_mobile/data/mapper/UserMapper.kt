package com.dexciuq.effective_mobile.data.mapper

import com.dexciuq.effective_mobile.data.model.local.UserEntity
import com.dexciuq.effective_mobile.domain.model.User

internal fun User.toEntity(): UserEntity = UserEntity(
    id = id,
    name = name,
    surname = surname,
    phoneNumber = phoneNumber,
)

internal fun UserEntity.toDomain(): User = User(
    id = id,
    name = name,
    surname = surname,
    phoneNumber = phoneNumber,
)