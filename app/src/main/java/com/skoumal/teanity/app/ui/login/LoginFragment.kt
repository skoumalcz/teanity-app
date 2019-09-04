package com.skoumal.teanity.app.ui.login

import com.skoumal.teanity.app.R
import com.skoumal.teanity.app.databinding.FragmentLoginBinding
import com.skoumal.teanity.app.view.AppFragment
import com.skoumal.teanity.util.Insets
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.core.qualifier.named
import org.koin.dsl.module

class LoginFragment : AppFragment<LoginViewModel, FragmentLoginBinding>() {

    companion object {
        private val scopeName = named<LoginFragment>()
        internal val loginModule = module {
            scope(scopeName) {
                viewModel { LoginViewModel() }
            }
        }
    }

    override val scopeName = LoginFragment.scopeName
    override val layoutRes = R.layout.fragment_login
    override val viewModel by viewModel<LoginViewModel>()

    override fun consumeSystemWindowInsets(left: Int, top: Int, right: Int, bottom: Int) =
        Insets(left, top, right, bottom)

}