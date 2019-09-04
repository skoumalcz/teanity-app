package com.skoumal.teanity.app.model.internal

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.ForeignKey.CASCADE
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Entity(
    tableName = "photo",
    foreignKeys = [
        ForeignKey(
            entity = User::class,
            parentColumns = ["id"],
            childColumns = ["uid"],
            onDelete = CASCADE
        )
    ]
)
@Parcelize
data class Photo(
    @PrimaryKey
    val id: String,
    val description: String,
    val url: String,
    val uid: String,
    val createdAt: Long
) : Parcelable