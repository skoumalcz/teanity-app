package com.skoumal.teanity.app.view

import androidx.databinding.ViewDataBinding
import androidx.lifecycle.LifecycleOwner
import com.skoumal.teanity.app.model.navigation.Destinations
import com.skoumal.teanity.view.TeanityFragment
import com.skoumal.teanity.viewevent.base.ViewEvent
import org.koin.android.ext.android.getKoin
import org.koin.android.scope.bindScope
import org.koin.android.viewmodel.ext.android.viewModel
import org.koin.core.parameter.ParametersDefinition
import org.koin.core.qualifier.Qualifier

abstract class AppFragment<ViewModel : AppViewModel, Binding : ViewDataBinding> :
    TeanityFragment<ViewModel, Binding>() {

    abstract val scopeName: Qualifier

    protected val scope by lazy {
        getKoin()
            .getOrCreateScope(this::class.java.simpleName, scopeName)
            .also { bindScope(it) }
    }

    override fun onEventDispatched(event: ViewEvent) {
        super.onEventDispatched(event)

        when (event) {
            Destinations.Up -> navController.navigateUp()
        }
    }

    protected inline fun <reified T : ViewModel> LifecycleOwner.viewModel(noinline parameters: ParametersDefinition? = null) =
        scope.viewModel<T>(this, parameters = parameters)

}