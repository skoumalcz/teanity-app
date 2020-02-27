package com.skoumal.teanity.app.ui.login

import com.skoumal.teanity.app.data.Config
import com.skoumal.teanity.app.view.AppViewModel

class LoginViewModel : AppViewModel() {

    fun logPressed() {
        Config.token = "token"
        LoginFragmentDirections.actionLoginFragmentToMain().publish()
    }

}