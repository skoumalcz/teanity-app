package com.skoumal.teanity.app.network.di

import com.skoumal.teanity.app.network.BuildConfig
import com.skoumal.teanity.app.network.DateToLongAdapter
import com.skoumal.teanity.app.network.TokenInterceptor
import com.skoumal.teanity.app.network.Unsplash
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.core.qualifier.named
import org.koin.dsl.module
import retrofit2.Converter
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import wiki.depasquale.responsesanitizer.ResponseSanitizer

internal val networkModule = module {
    single { ResponseSanitizer() }
    single { createLogging() }
    single { createClient(get(), get(), get()) }
    single { createMoshi() }

    single { TokenInterceptor(get(named<TokenInterceptor>())) }
    single<Converter.Factory> { createConverter(get()) }

    single { createRetrofit(get(), get()) }
    single { createService<Unsplash>(get(), Unsplash.url) }
}

private val appLoggingLevel
    get() = when (BuildConfig.DEBUG) {
        true -> HttpLoggingInterceptor.Level.BODY
        else -> HttpLoggingInterceptor.Level.NONE
    }

private fun createLogging() = HttpLoggingInterceptor().apply {
    level = appLoggingLevel
}

private fun createClient(
    sanitizer: ResponseSanitizer,
    logging: HttpLoggingInterceptor,
    token: TokenInterceptor
) = OkHttpClient.Builder()
    .addInterceptor(token)
    .addInterceptor(sanitizer)
    .addInterceptor(logging)
    .build()

private fun createConverter(moshi: Moshi) = MoshiConverterFactory.create(moshi)

private fun createMoshi() = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .add(DateToLongAdapter())
    .build()

private fun createRetrofit(
    okHttpClient: OkHttpClient,
    converterFactory: Converter.Factory
) = Retrofit.Builder()
    .addConverterFactory(converterFactory)
    .client(okHttpClient)

private inline fun <reified T> createService(
    retrofitBuilder: Retrofit.Builder,
    baseUrl: String
) = retrofitBuilder
    .baseUrl(baseUrl)
    .build()
    .create(T::class.java)