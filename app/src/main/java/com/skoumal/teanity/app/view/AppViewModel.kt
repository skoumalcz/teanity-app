package com.skoumal.teanity.app.view

import com.skoumal.teanity.app.model.navigation.Destinations
import com.skoumal.teanity.tools.annotation.SubjectsToChange
import com.skoumal.teanity.viewmodel.LiveStateViewModel
import com.skoumal.teanity.viewmodel.LoadingViewModel

abstract class AppViewModel : LoadingViewModel() {

    fun upPressed() = Destinations.Up().publish()

}

@OptIn(SubjectsToChange::class)
abstract class AppStateViewModel<State : Any>(initial: State? = null) :
    LiveStateViewModel<State>(initial) {

    fun upPressed() = Destinations.Up().publish()

}