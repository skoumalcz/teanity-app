package com.skoumal.teanity.app.persistence.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Query
import com.skoumal.teanity.app.model.internal.User
import com.skoumal.teanity.persistence.BaseDao

@Dao
internal interface UserDao : BaseDao<User> {

    @Query("SELECT * FROM user WHERE user.id = :id LIMIT 1")
    fun observeById(id: String): LiveData<User?>

    @Query("SELECT * FROM user WHERE user.id = :id LIMIT 1")
    suspend fun byId(id: String): User?

}