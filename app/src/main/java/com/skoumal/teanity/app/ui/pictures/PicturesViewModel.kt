package com.skoumal.teanity.app.ui.pictures

import com.skoumal.teanity.app.BR
import com.skoumal.teanity.app.data.usecase.PhotoLoadUseCase
import com.skoumal.teanity.app.model.navigation.Navigation
import com.skoumal.teanity.app.model.recyclable.PhotoItem
import com.skoumal.teanity.app.persistence.usecase.PhotoUseCase
import com.skoumal.teanity.app.view.AppViewModel
import com.skoumal.teanity.extensions.bindingOf
import com.skoumal.teanity.extensions.diffListOf
import com.skoumal.teanity.persistence.invoke

class PicturesViewModel(
    private val photos: PhotoUseCase,
    private val load: PhotoLoadUseCase
) : AppViewModel() {

    val items = diffListOf<PhotoItem>()
    val itemBinding = bindingOf<PhotoItem> { it.bindExtra(BR.viewModel, this) }

    init {
        photos().observeForever {
            updateItems(it.map { photo -> PhotoItem(photo) })
        }
    }

    override suspend fun refresh() {
        PhotoLoadUseCase
            .Params(items.size / 10)
            .let { load.now(it) }
    }

    fun photoPressed(item: PhotoItem) = Navigation.detail(item.item).publish()

    // ---

    private fun updateItems(new: List<PhotoItem>) = launch {
        items.update(new, items.computeDiff(new))
    }

}