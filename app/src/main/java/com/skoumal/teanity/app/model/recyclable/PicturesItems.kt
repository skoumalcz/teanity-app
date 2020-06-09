package com.skoumal.teanity.app.model.recyclable

import com.skoumal.teanity.app.R
import com.skoumal.teanity.app.model.internal.Photo
import com.skoumal.teanity.databinding.ComparableRvItem
import com.skoumal.teanity.databinding.GenericRvItem

class PhotoItem(val item: Photo) : GenericRvItem() {
    override val layoutRes = R.layout.item_photo

    override fun contentSameAs(other: GenericRvItem) =
        other.compareTo<PhotoItem> { item == it.item }

    override fun sameAs(other: GenericRvItem) =
        other.compareTo<PhotoItem> { item.url == it.item.url }
}

inline fun <reified T> ComparableRvItem<T>.compareTo(body: (T) -> Boolean): Boolean {
    return this is T && body(this)
}
