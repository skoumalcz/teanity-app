package com.skoumal.teanity.app.ui

import com.skoumal.teanity.app.R
import com.skoumal.teanity.app.databinding.ActivityHomeBinding
import com.skoumal.teanity.app.view.AppActivity
import com.skoumal.teanity.util.Insets
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.core.qualifier.named
import org.koin.dsl.module

class HomeActivity : AppActivity<HomeViewModel, ActivityHomeBinding>() {

    companion object {
        private val scopeName = named<HomeActivity>()
        internal val homeModule = module {
            scope(scopeName) {
                viewModel { HomeViewModel() }
            }
        }
    }

    override val scopeName = HomeActivity.scopeName
    override val layoutRes = R.layout.activity_home
    override val viewModel by viewModel<HomeViewModel>()
    override val navHostId = R.id.home_content

    override fun peekSystemWindowInsets(insets: Insets) {
        viewModel.insets.value = insets
    }

}