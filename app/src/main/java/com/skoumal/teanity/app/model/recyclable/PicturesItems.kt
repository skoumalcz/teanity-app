package com.skoumal.teanity.app.model.recyclable

import com.skoumal.teanity.app.R
import com.skoumal.teanity.app.model.internal.Photo
import com.skoumal.teanity.databinding.RecyclerViewItem

class PhotoItem(val item: Photo) : RecyclerViewItem() {
    override val layoutRes = R.layout.item_photo

    override fun contentSameAs(other: RecyclerViewItem) =
        other.compareTo<PhotoItem> { item == it.item }

    override fun sameAs(other: RecyclerViewItem) =
        other.compareTo<PhotoItem> { item.url == it.item.url }
}

inline fun <reified T> RecyclerViewItem.compareTo(body: (T) -> Boolean): Boolean {
    return this is T && body(this)
}
