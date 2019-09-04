package com.skoumal.teanity.app.model.internal

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user")
data class User(
    @PrimaryKey
    val id: String,
    val username: String,
    val name: String
)