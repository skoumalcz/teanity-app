package com.skoumal.teanity.app.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.ViewDataBinding
import com.skoumal.teanity.view.TeanityFragment

abstract class AppFragment<ViewModel : AppViewModel, Binding : ViewDataBinding> :
    TeanityFragment<ViewModel, Binding>() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val superCall = super.onCreateView(inflater, container, savedInstanceState)
        binding.executePendingBindings()
        return superCall
    }

}