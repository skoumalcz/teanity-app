package com.skoumal.teanity.app.view

import androidx.databinding.ViewDataBinding
import com.skoumal.teanity.view.TeanityActivity

abstract class AppActivity<ViewModel : AppViewModel, Binding : ViewDataBinding> :
    TeanityActivity<ViewModel, Binding>()