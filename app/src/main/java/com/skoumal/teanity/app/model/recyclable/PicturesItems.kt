package com.skoumal.teanity.app.model.recyclable

import com.skoumal.teanity.app.R
import com.skoumal.teanity.app.model.internal.Photo
import com.skoumal.teanity.databinding.GenericRvItem
import com.skoumal.teanity.extensions.compareToSafe

class PhotoItem(val item: Photo) : GenericRvItem() {
    override val layoutRes = R.layout.item_photo

    override fun contentSameAs(other: GenericRvItem) =
        other.compareToSafe<PhotoItem> { item == it.item }

    override fun sameAs(other: GenericRvItem) =
        other.compareToSafe<PhotoItem> { item.url == it.item.url }
}