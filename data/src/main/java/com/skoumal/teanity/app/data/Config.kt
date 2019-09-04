package com.skoumal.teanity.app.data

import android.content.Context
import com.chibatching.kotpref.ContextProvider
import com.chibatching.kotpref.KotprefModel
import org.koin.core.KoinComponent
import org.koin.core.get

object Config : KotprefModel(provider) {

    var token by stringPref(default = "", key = "token")

    // ---

    val isLoggedIn get() = token.isNotEmpty()

}

private val provider = object : ContextProvider, KoinComponent {
    override fun getApplicationContext(): Context = get()
}