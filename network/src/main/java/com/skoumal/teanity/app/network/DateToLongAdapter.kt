package com.skoumal.teanity.app.network

import com.squareup.moshi.FromJson
import java.text.SimpleDateFormat
import java.util.*

internal class DateToLongAdapter {

    private val converter = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssXXX", Locale.getDefault())

    @FromJson
    fun fromJson(input: String): Long {
        return converter.parse(input).time
    }

}