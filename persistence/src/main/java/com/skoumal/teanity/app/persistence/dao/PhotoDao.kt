package com.skoumal.teanity.app.persistence.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Query
import com.skoumal.teanity.app.model.internal.Photo
import com.skoumal.teanity.persistence.BaseDao

@Dao
internal interface PhotoDao : BaseDao<Photo> {

    @Query("SELECT * FROM photo ORDER BY photo.createdAt DESC")
    fun observeAll(): LiveData<List<Photo>?>

    @Query("SELECT * FROM photo ORDER BY photo.createdAt DESC")
    suspend fun all(): List<Photo>

    @Query("SELECT * FROM photo ORDER BY photo.createdAt DESC LIMIT :limit OFFSET :offset")
    suspend fun page(offset: Int, limit: Int): List<Photo>

    @Query("SELECT COUNT(*) FROM photo")
    suspend fun count(): Int

}