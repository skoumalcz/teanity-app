package com.skoumal.teanity.app.model.inbound

import com.skoumal.teanity.app.model.internal.Photo
import com.skoumal.teanity.app.model.internal.User
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class InPhoto(
    @Json(name = "id")
    val id: String = "",
    @Json(name = "description")
    val description: String = "",
    @Json(name = "fuck_this_ill_make_my_own")
    val createdAt: Long = System.currentTimeMillis(),
    @Json(name = "urls")
    val urls: InUrls = InUrls(),
    @Json(name = "user")
    val user: InUser = InUser()
)

val InPhoto.internal get() = Photo(id, description, urls.regular, user.id, createdAt)

fun InPhoto.divide(): Pair<Photo, User> {
    return internal to user.internal
}