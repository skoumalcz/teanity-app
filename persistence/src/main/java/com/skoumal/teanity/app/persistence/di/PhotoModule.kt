package com.skoumal.teanity.app.persistence.di

import com.skoumal.teanity.app.persistence.Persistence
import com.skoumal.teanity.app.persistence.usecase.GetPhotoUseCase
import com.skoumal.teanity.app.persistence.usecase.PutPhotoUseCase
import org.koin.dsl.module

internal val photoModule = module {
    single { get<Persistence>().photo() }
    single { GetPhotoUseCase(get()) }
    single { PutPhotoUseCase(get()) }
}