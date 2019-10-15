package com.skoumal.teanity.app.data.di

import com.skoumal.teanity.app.data.usecase.PutRemotePhotosUseCase
import org.koin.dsl.module

internal val photoModule = module {
    single { PutRemotePhotosUseCase(get(), get(), get()) }
}