package com.skoumal.teanity.app.persistence.di

import com.skoumal.teanity.app.persistence.Persistence
import com.skoumal.teanity.app.persistence.usecase.UserInsertUseCase
import com.skoumal.teanity.app.persistence.usecase.UserUseCase
import org.koin.dsl.module

internal val userModule = module {
    single { get<Persistence>().user() }
    single { UserUseCase(get()) }
    single { UserInsertUseCase(get()) }
}