package com.skoumal.teanity.app.persistence.di

import com.skoumal.teanity.app.persistence.Persistence
import com.skoumal.teanity.app.persistence.usecase.GetUserByIdUseCase
import com.skoumal.teanity.app.persistence.usecase.PutUserUseCase
import org.koin.dsl.module

internal val userModule = module {
    single { get<Persistence>().user() }
    single { GetUserByIdUseCase(get()) }
    single { PutUserUseCase(get()) }
}