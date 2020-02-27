package com.skoumal.teanity.app.ui

import androidx.core.graphics.Insets
import com.skoumal.teanity.app.R
import com.skoumal.teanity.app.databinding.ActivityHomeBinding
import com.skoumal.teanity.app.view.AppActivity
import org.koin.android.viewmodel.ext.android.viewModel

class HomeActivity : AppActivity<HomeViewModel, ActivityHomeBinding>() {

    override val layoutRes = R.layout.activity_home
    override val viewModel by viewModel<HomeViewModel>()
    override val navHostId = R.id.home_content

    override fun peekSystemWindowInsets(insets: Insets) {
        viewModel.insets = insets
    }

}