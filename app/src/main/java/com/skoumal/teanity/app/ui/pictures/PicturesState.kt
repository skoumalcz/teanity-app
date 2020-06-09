package com.skoumal.teanity.app.ui.pictures

import androidx.recyclerview.widget.DiffUtil
import com.skoumal.teanity.app.model.internal.Photo
import com.skoumal.teanity.app.model.recyclable.PhotoItem

sealed class PicturesState {

    object Loading : PicturesState()

    data class RecentlyLoaded(
        val items: List<Photo>
    ) : PicturesState()

    data class Loaded(
        val items: List<PhotoItem>,
        val diff: DiffUtil.DiffResult
    ) : PicturesState()

}