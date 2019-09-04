package com.skoumal.teanity.app.persistence.di

import com.skoumal.teanity.app.persistence.Persistence
import com.skoumal.teanity.app.persistence.usecase.PhotoInsertUseCase
import com.skoumal.teanity.app.persistence.usecase.PhotoUseCase
import org.koin.dsl.module

internal val photoModule = module {
    single { get<Persistence>().photo() }
    single { PhotoUseCase(get()) }
    single { PhotoInsertUseCase(get()) }
}