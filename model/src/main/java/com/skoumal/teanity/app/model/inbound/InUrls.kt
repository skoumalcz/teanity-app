package com.skoumal.teanity.app.model.inbound

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class InUrls(
    @Json(name = "raw")
    val raw: String = "",
    @Json(name = "full")
    val full: String = "",
    @Json(name = "regular")
    val regular: String = "",
    @Json(name = "small")
    val small: String = "",
    @Json(name = "thumb")
    val thumb: String = ""
)