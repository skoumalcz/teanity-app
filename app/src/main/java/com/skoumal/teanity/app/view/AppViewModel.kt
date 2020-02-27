package com.skoumal.teanity.app.view

import com.skoumal.teanity.app.model.navigation.Destinations
import com.skoumal.teanity.viewmodel.LoadingViewModel

abstract class AppViewModel : LoadingViewModel() {

    fun upPressed() = Destinations.Up().publish()

}