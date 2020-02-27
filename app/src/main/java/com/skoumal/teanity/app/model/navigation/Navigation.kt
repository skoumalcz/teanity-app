package com.skoumal.teanity.app.model.navigation

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.skoumal.teanity.viewevent.base.ActivityExecutor
import com.skoumal.teanity.viewevent.base.FragmentExecutor
import com.skoumal.teanity.viewevent.base.ViewEvent

sealed class Destinations : ViewEvent(), ActivityExecutor, FragmentExecutor {

    class Up : Destinations() {
        override fun invoke(activity: AppCompatActivity) {
            activity.onBackPressed()
        }

        override fun invoke(fragment: Fragment) {
            fragment.activity?.onBackPressed()
        }
    }

}