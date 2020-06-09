package com.skoumal.teanity.app.persistence.di

import com.skoumal.teanity.app.persistence.Persistence
import com.skoumal.teanity.app.persistence.usecase.GetPhotoCountUseCase
import com.skoumal.teanity.app.persistence.usecase.GetPhotosUseCase
import com.skoumal.teanity.app.persistence.usecase.PutPhotoUseCase
import org.koin.dsl.module

internal val photoModule = module {
    single { get<Persistence>().photo() }
    single { GetPhotosUseCase(get()) }
    single { PutPhotoUseCase(get()) }
    single { GetPhotoCountUseCase(get()) }
}