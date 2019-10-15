package com.skoumal.teanity.app.model.navigation

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.skoumal.teanity.app.R
import com.skoumal.teanity.app.model.internal.Photo
import com.skoumal.teanity.viewevent.NavigationEvent
import com.skoumal.teanity.viewevent.base.ActivityExecutor
import com.skoumal.teanity.viewevent.base.FragmentExecutor
import com.skoumal.teanity.viewevent.base.ViewEvent

object Navigation {

    fun up() = Destinations.Up

    fun login() = NavigationEvent {
        navDirections { destination = R.id.login }
    }

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

sealed class Destinations : ViewEvent(), ActivityExecutor, FragmentExecutor {

    object Up : Destinations() {
        override fun invoke(activity: AppCompatActivity) {
            activity.onBackPressed()
        }

        override fun invoke(fragment: Fragment) {
            fragment.activity?.onBackPressed()
        }
    }

}