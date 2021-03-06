package com.skoumal.teanity.app.util

import android.widget.ImageView
import android.widget.ViewFlipper
import androidx.databinding.BindingAdapter
import coil.api.load
import coil.transform.RoundedCornersTransformation

@BindingAdapter("url", requireAll = false)
fun setImageFromUrl(view: ImageView, url: String?) {
    if (url.isNullOrBlank()) {
        return
    }

    view.load(url) {
        transformations(RoundedCornersTransformation(10f, 10f, 10f, 10f))
    }
}

@BindingAdapter("selectedView")
fun ViewFlipper.setSelectedViewIndex(selectedViewIndex: Int) {
    displayedChild = selectedViewIndex.coerceIn(0 until childCount)
}