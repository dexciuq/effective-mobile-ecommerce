package com.dexciuq.effective_mobile.data.datasource.preference

import android.content.SharedPreferences
import com.dexciuq.effective_mobile.data.datasource.DataSource
import javax.inject.Inject

private const val AUTH_SKIP = "auth_skip"

class PreferenceDataSourceImpl @Inject constructor(
    private val sharedPreferences: SharedPreferences
) : DataSource.PreferenceDataSource {
    override suspend fun getAuthSkip(): Boolean =
        sharedPreferences.getBoolean(AUTH_SKIP, false)

    override suspend fun setAuthSkip(skip: Boolean) =
        sharedPreferences.edit().putBoolean(AUTH_SKIP, skip).apply()
}