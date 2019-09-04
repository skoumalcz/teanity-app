package com.skoumal.teanity.app.network

import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response
import java.io.IOException

class TokenInterceptor internal constructor(
    private val key: String
) : Interceptor {
    companion object {
        private const val NO_AUTH_HEADER_NAME = "No-authentication"
        private const val AUTH_HEADER_NAME = "Authorization"

        const val NO_AUTH_HEADER = "$NO_AUTH_HEADER_NAME: true"
    }

    private val token get() = "Client-ID $key"

    @Throws(IOException::class)
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request().edit {
            if (it.header(NO_AUTH_HEADER_NAME) == null) {
                addHeader(AUTH_HEADER_NAME, token)
            } else {
                removeHeader(NO_AUTH_HEADER_NAME)
            }
        }

        return chain.proceed(request)
    }

    private fun Request.edit(builder: Request.Builder.(Request) -> Unit): Request = newBuilder()
        .apply { builder(this@edit) }
        .build()
}