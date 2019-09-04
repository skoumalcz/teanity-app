package com.skoumal.teanity.app

import android.app.Application
import com.skoumal.teanity.app.data.di.dataModules
import com.skoumal.teanity.app.di.appModules
import com.skoumal.teanity.app.network.di.networkModules
import com.skoumal.teanity.app.persistence.di.persistenceModules
import com.skoumal.teanity.di.Teanity
import timber.log.Timber

class App : Application() {

    override fun onCreate() {
        super.onCreate()

        Timber.plant(Timber.DebugTree())

        Teanity.startWith(this, persistenceModules + networkModules + dataModules + appModules)
    }

}