package com.skoumal.teanity.app.ui.detail

import androidx.core.graphics.Insets
import com.skoumal.teanity.app.R
import com.skoumal.teanity.app.databinding.FragmentDetailBinding
import com.skoumal.teanity.app.model.navigation.photo
import com.skoumal.teanity.app.view.AppFragment
import org.koin.android.viewmodel.ext.android.viewModel
import org.koin.core.parameter.parametersOf

class DetailFragment : AppFragment<DetailViewModel, FragmentDetailBinding>() {

    override val layoutRes = R.layout.fragment_detail
    override val viewModel by viewModel<DetailViewModel> {
        parametersOf(requireArguments().photo)
    }

    override fun consumeSystemWindowInsets(insets: Insets) = insets

}