package com.skoumal.teanity.app.data.di

import com.skoumal.teanity.app.data.usecase.PhotoLoadUseCase
import org.koin.dsl.module

internal val photoModule = module {
    single { PhotoLoadUseCase(get(), get(), get()) }
}