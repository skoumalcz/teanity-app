package com.skoumal.teanity.app.model.recyclable

import com.skoumal.teanity.app.R
import com.skoumal.teanity.app.model.internal.Photo
import com.skoumal.teanity.databinding.GenericRvItem
import com.skoumal.teanity.databinding.Item
import com.skoumal.teanity.extensions.compareToSafe

class PhotoItem(override val item: Photo) : Item<Photo>() {
    override val layoutRes = R.layout.item_photo

    override fun sameAs(other: GenericRvItem) =
        other.compareToSafe<PhotoItem> { item.id == it.item.id }
}