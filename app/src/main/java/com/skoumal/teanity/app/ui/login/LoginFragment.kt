package com.skoumal.teanity.app.ui.login

import androidx.core.graphics.Insets
import com.skoumal.teanity.app.R
import com.skoumal.teanity.app.databinding.FragmentLoginBinding
import com.skoumal.teanity.app.view.AppFragment
import org.koin.android.viewmodel.ext.android.viewModel

class LoginFragment : AppFragment<LoginViewModel, FragmentLoginBinding>() {

    override val layoutRes = R.layout.fragment_login
    override val viewModel by viewModel<LoginViewModel>()

    override fun consumeSystemWindowInsets(insets: Insets) = insets

}