package com.skoumal.teanity.app.ui.pictures

import com.skoumal.teanity.app.BR
import com.skoumal.teanity.app.data.usecase.PutRemotePhotosUseCase
import com.skoumal.teanity.app.model.navigation.Navigation
import com.skoumal.teanity.app.model.recyclable.PhotoItem
import com.skoumal.teanity.app.persistence.usecase.GetPhotoUseCase
import com.skoumal.teanity.app.view.AppViewModel
import com.skoumal.teanity.extensions.bindingOf
import com.skoumal.teanity.extensions.diffListOf
import com.skoumal.teanity.persistence.UseCaseState
import com.skoumal.teanity.persistence.extensions.map
import com.skoumal.teanity.persistence.invoke
import kotlin.math.roundToInt

class PicturesViewModel(
    private val photos: GetPhotoUseCase,
    private val load: PutRemotePhotosUseCase
) : AppViewModel() {

    val items = diffListOf<PhotoItem>()
    val itemBinding = bindingOf<PhotoItem> { it.bindExtra(BR.viewModel, this) }
    val isLoadingPhotos = load.observeState().map { it == UseCaseState.LOADING }

    init {
        photos()
            .map { it.map { photo -> PhotoItem(photo) } }
            .observeForever { updateItems(it) }
    }

    override suspend fun refresh() {
        PutRemotePhotosUseCase
            .Params((items.size / 10f).roundToInt() + 1)
            .let { load(it) }
    }

    fun photoPressed(item: PhotoItem) = Navigation.detail(item.item).publish()

    // ---

    private fun updateItems(new: List<PhotoItem>) = launch {
        items.update(new, items.computeDiff(new))
    }

}