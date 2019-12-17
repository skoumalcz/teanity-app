package com.skoumal.teanity.app.ui

import android.os.Bundle
import androidx.core.graphics.Insets
import com.skoumal.teanity.app.R
import com.skoumal.teanity.app.data.Config
import com.skoumal.teanity.app.databinding.ActivityHomeBinding
import com.skoumal.teanity.app.model.navigation.Navigation
import com.skoumal.teanity.app.view.AppActivity
import org.koin.android.viewmodel.ext.android.viewModel

class HomeActivity : AppActivity<HomeViewModel, ActivityHomeBinding>() {

    override val layoutRes = R.layout.activity_home
    override val viewModel by viewModel<HomeViewModel>()
    override val navHostId = R.id.home_content

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        if (!Config.isLoggedIn) {
            Navigation.login().onSelf()
        }
    }

    override fun peekSystemWindowInsets(insets: Insets) {
        viewModel.insets.value = insets
    }

}