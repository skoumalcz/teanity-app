package com.skoumal.teanity.app.ui.detail

import com.skoumal.teanity.app.R
import com.skoumal.teanity.app.databinding.FragmentDetailBinding
import com.skoumal.teanity.app.model.internal.Photo
import com.skoumal.teanity.app.model.navigation.photo
import com.skoumal.teanity.app.view.AppFragment
import com.skoumal.teanity.util.Insets
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.core.parameter.parametersOf
import org.koin.core.qualifier.named
import org.koin.dsl.module

class DetailFragment : AppFragment<DetailViewModel, FragmentDetailBinding>() {

    companion object {
        private val scopeName = named<DetailFragment>()
        internal val detailModule = module {
            scope(scopeName) {
                viewModel { (photo: Photo) -> DetailViewModel(photo, get()) }
            }
        }
    }

    override val scopeName = DetailFragment.scopeName
    override val layoutRes = R.layout.fragment_detail
    override val viewModel by viewModel<DetailViewModel> {
        parametersOf(requireArguments().photo)
    }

    override fun consumeSystemWindowInsets(left: Int, top: Int, right: Int, bottom: Int) =
        Insets(left, top, right, bottom)

}