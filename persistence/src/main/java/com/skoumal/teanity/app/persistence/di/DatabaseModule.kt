package com.skoumal.teanity.app.persistence.di

import android.content.Context
import androidx.room.Room
import com.skoumal.teanity.app.persistence.Persistence
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

internal val databaseModule = module {
    single { createDatabase(androidContext()) }
}

private fun createDatabase(context: Context) =
    Room.databaseBuilder(context, Persistence::class.java, Persistence.name).build()