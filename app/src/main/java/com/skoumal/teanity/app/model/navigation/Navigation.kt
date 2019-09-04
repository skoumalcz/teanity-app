package com.skoumal.teanity.app.model.navigation

import com.skoumal.teanity.app.R
import com.skoumal.teanity.app.model.internal.Photo
import com.skoumal.teanity.viewevent.NavigationEvent
import com.skoumal.teanity.viewevent.base.ViewEvent

object Navigation {

    fun up() = Destinations.Up

    fun detail(it: Photo) = NavigationEvent {
        navDirections { destination = R.id.detailFragment }
        navOptions {
            anim {
                enter = R.anim.enter
                exit = R.anim.exit
                popEnter = R.anim.pop_enter
                popExit = R.anim.pop_exit
            }
        }
        args { photo = it }
    }

}

sealed class Destinations : ViewEvent() {

    object Up : Destinations()

}