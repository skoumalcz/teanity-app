package com.skoumal.teanity.app.ui.pictures

import android.os.Bundle
import android.view.View
import androidx.core.graphics.Insets
import com.skoumal.teanity.app.R
import com.skoumal.teanity.app.data.Config
import com.skoumal.teanity.app.databinding.FragmentPicturesBinding
import com.skoumal.teanity.app.view.AppFragment
import org.koin.android.viewmodel.ext.android.viewModel

class PicturesFragment : AppFragment<PicturesViewModel, FragmentPicturesBinding>() {

    override val layoutRes = R.layout.fragment_pictures
    override val viewModel by viewModel<PicturesViewModel>()

    override fun consumeSystemWindowInsets(insets: Insets) = insets

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (!Config.isLoggedIn) {
            with(teanityActivity!!) {
                PicturesFragmentDirections.actionPicturesFragmentToLogin().navigate()
            }
        }
    }

}