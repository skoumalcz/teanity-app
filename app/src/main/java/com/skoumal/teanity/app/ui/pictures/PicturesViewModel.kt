package com.skoumal.teanity.app.ui.pictures

import androidx.lifecycle.Transformations
import com.skoumal.teanity.app.BR
import com.skoumal.teanity.app.data.usecase.PutRemotePhotosUseCase
import com.skoumal.teanity.app.model.recyclable.PhotoItem
import com.skoumal.teanity.app.persistence.usecase.GetPhotosUseCase
import com.skoumal.teanity.app.view.AppStateViewModel
import com.skoumal.teanity.extensions.calculateDiff
import com.skoumal.teanity.list.BindingAdapter
import kotlinx.coroutines.delay

class PicturesViewModel(
    photos: GetPhotosUseCase,
    private val remote: PutRemotePhotosUseCase
) : AppStateViewModel<PicturesState>(PicturesState.Loading) {

    val adapter = BindingAdapter<PhotoItem> {
        it.setVariable(BR.viewModel, this)
    }

    val stateIndex = Transformations.map(state) {
        when (it) {
            is PicturesState.RecentlyLoaded,
            PicturesState.Loading -> 0
            is PicturesState.Loaded -> if (it.items.isEmpty()) 2 else 1
            null -> 0
        }
    }

    init {
        photos.observe(Unit).observe {
            PicturesState.RecentlyLoaded(it.orEmpty()).publish()
        }
        state.observe {
            when (it) {
                is PicturesState.Loaded -> adapter.update(it.items, it.diff)
            }
        }
    }

    override suspend fun refresh() {
        remote(PutRemotePhotosUseCase.Params((adapter.items.size / 10) + 1, 10))
    }

    override suspend fun mutateState(
        oldState: PicturesState?,
        newState: PicturesState
    ): PicturesState {
        delay(1000)
        return when (newState) {
            is PicturesState.RecentlyLoaded -> {
                val newItems = newState.items.map { PhotoItem(it) }
                PicturesState.Loaded(
                    newItems,
                    adapter.getCallbackFrom(newItems).calculateDiff()
                )
            }
            else -> newState
        }
    }

    fun photoPressed(item: PhotoItem) = PicturesFragmentDirections
        .actionPicturesFragmentToDetailFragment(item.item)
        .publish()

}