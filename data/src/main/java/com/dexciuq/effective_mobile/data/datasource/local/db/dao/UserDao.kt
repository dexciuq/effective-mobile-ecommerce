package com.dexciuq.effective_mobile.data.datasource.local.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.dexciuq.effective_mobile.data.model.local.UserEntity
import com.dexciuq.effective_mobile.domain.model.User

@Dao
interface UserDao {

    @Query("SELECT * FROM users WHERE id = :id LIMIT 1")
    suspend fun selectUser(id: Int = User.USER_ID): UserEntity

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(userEntity: UserEntity)

    @Query("DELETE FROM users ")
    suspend fun delete()
}