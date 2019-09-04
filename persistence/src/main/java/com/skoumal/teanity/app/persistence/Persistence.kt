package com.skoumal.teanity.app.persistence

import androidx.room.Database
import androidx.room.RoomDatabase
import com.skoumal.teanity.app.model.internal.Photo
import com.skoumal.teanity.app.model.internal.User
import com.skoumal.teanity.app.persistence.dao.PhotoDao
import com.skoumal.teanity.app.persistence.dao.UserDao

@Database(
    version = 1,
    entities = [
        Photo::class,
        User::class
    ]
)
abstract class Persistence : RoomDatabase() {

    companion object {
        const val name = "persistent-data"
    }

    internal abstract fun photo(): PhotoDao
    internal abstract fun user(): UserDao
}