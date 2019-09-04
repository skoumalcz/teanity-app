package com.skoumal.teanity.app.ui.pictures

import com.skoumal.teanity.app.R
import com.skoumal.teanity.app.databinding.FragmentPicturesBinding
import com.skoumal.teanity.app.view.AppFragment
import com.skoumal.teanity.util.Insets
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.core.qualifier.named
import org.koin.dsl.module

class PicturesFragment : AppFragment<PicturesViewModel, FragmentPicturesBinding>() {

    companion object {
        private val scopeName = named<PicturesFragment>()
        internal val picturesModule = module {
            scope(scopeName) {
                viewModel { PicturesViewModel(get(), get()) }
            }
        }
    }

    override val scopeName = PicturesFragment.scopeName
    override val layoutRes = R.layout.fragment_pictures
    override val viewModel by viewModel<PicturesViewModel>()

    override fun consumeSystemWindowInsets(left: Int, top: Int, right: Int, bottom: Int) =
        Insets(left = left, top = top, right = right, bottom = bottom)

}