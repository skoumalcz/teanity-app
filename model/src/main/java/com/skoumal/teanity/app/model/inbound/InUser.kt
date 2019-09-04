package com.skoumal.teanity.app.model.inbound

import com.skoumal.teanity.app.model.internal.User
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class InUser(
    @Json(name = "id")
    val id: String = "",
    @Json(name = "username")
    val username: String = "",
    @Json(name = "name")
    val name: String = ""
)

val InUser.internal get() = User(id, username, name)