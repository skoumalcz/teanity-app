package com.skoumal.teanity.app.view

import android.os.Bundle
import androidx.databinding.ViewDataBinding
import com.skoumal.teanity.app.R
import com.skoumal.teanity.ui.extensions.translucency
import com.skoumal.teanity.ui.extensions.transparency
import com.skoumal.teanity.view.TeanityActivity

abstract class AppActivity<ViewModel : AppViewModel, Binding : ViewDataBinding> :
    TeanityActivity<ViewModel, Binding>() {

    override fun onCreate(savedInstanceState: Bundle?) {
        setTheme(R.style.Theme)
        translucency {
            isNavBarTranslucent = true
            isStatusBarTranslucent = true
        }
        transparency {
            isNavBarTransparent = true
            isNavBarLight = !isDarkMode
            isStatusBarTransparent = true
            isStatusBarLight = !isDarkMode
        }
        super.onCreate(savedInstanceState)
    }

}