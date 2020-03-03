package com.skoumal.teanity.app.ui.pictures

import com.skoumal.teanity.app.BR
import com.skoumal.teanity.app.data.usecase.PutRemotePhotosUseCase
import com.skoumal.teanity.app.model.recyclable.PhotoItem
import com.skoumal.teanity.app.persistence.usecase.GetPhotoUseCase
import com.skoumal.teanity.app.view.AppViewModel
import com.skoumal.teanity.component.UseCaseState
import com.skoumal.teanity.component.extensions.map
import com.skoumal.teanity.component.invoke
import com.skoumal.teanity.extensions.bindingOf
import com.skoumal.teanity.extensions.calculateDiffAsync
import com.skoumal.teanity.extensions.diffListOf
import kotlinx.coroutines.launch
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

    fun photoPressed(item: PhotoItem) = PicturesFragmentDirections
        .actionPicturesFragmentToDetailFragment(item.item)
        .publish()

    // ---

    private fun updateItems(new: List<PhotoItem>) = launch {
        items.update(new, items.calculateDiffAsync(new))
    }

}