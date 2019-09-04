package com.skoumal.teanity.app.view

import com.skoumal.teanity.app.model.navigation.Navigation
import com.skoumal.teanity.viewmodel.LoadingViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.CoroutineStart
import kotlin.coroutines.CoroutineContext

abstract class AppViewModel : LoadingViewModel() {

    fun upPressed() = Navigation.up().publish()

    fun launchLoading(
        context: CoroutineContext = coroutineContext,
        start: CoroutineStart = CoroutineStart.DEFAULT,
        block: suspend CoroutineScope.() -> Unit
    ) = launch(context, start) {
        state = State.LOADING
        block()
        state = State.LOADED
    }

}