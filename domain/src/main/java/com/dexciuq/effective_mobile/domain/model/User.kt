package com.dexciuq.effective_mobile.domain.model

data class User(
    val id: Int = USER_ID,
    val name: String,
    val surname: String,
    val phoneNumber: String,
) {
    companion object {
        const val USER_ID = 777
    }
}