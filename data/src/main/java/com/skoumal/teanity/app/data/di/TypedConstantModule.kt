package com.skoumal.teanity.app.data.di

import com.skoumal.teanity.app.data.Constants
import org.koin.core.qualifier.named
import org.koin.dsl.module

internal val typedConstantModule = module {
    single(named("token")) { Constants.accessKey }
}