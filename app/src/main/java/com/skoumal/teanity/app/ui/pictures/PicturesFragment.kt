package com.skoumal.teanity.app.ui.pictures

import androidx.core.graphics.Insets
import com.skoumal.teanity.app.R
import com.skoumal.teanity.app.databinding.FragmentPicturesBinding
import com.skoumal.teanity.app.view.AppFragment
import org.koin.android.viewmodel.ext.android.viewModel

class PicturesFragment : AppFragment<PicturesViewModel, FragmentPicturesBinding>() {

    override val layoutRes = R.layout.fragment_pictures
    override val viewModel by viewModel<PicturesViewModel>()

    override fun consumeSystemWindowInsets(insets: Insets) = insets

}