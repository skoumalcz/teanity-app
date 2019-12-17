package com.skoumal.teanity.app.view

import com.skoumal.teanity.app.model.navigation.Navigation
import com.skoumal.teanity.viewmodel.LoadingViewModel

abstract class AppViewModel : LoadingViewModel() {

    fun upPressed() = Navigation.up().publish()

}