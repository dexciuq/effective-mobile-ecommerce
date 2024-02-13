package com.dexciuq.effective_mobile.presentation.screen.profile

import androidx.annotation.DrawableRes

sealed class ProfileAdapterModel {
    data class ProfileInfo(
        @DrawableRes
        val icon: Int,
        @DrawableRes
        val endIcon: Int,
        val title: String,
        val description: String,
    ) : ProfileAdapterModel()

    data class MenuInfo(
        @DrawableRes
        val icon: Int,
        val title: String,
    ) : ProfileAdapterModel()
}