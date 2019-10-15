package com.skoumal.teanity.app.util

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.request.RequestOptions
import com.skoumal.teanity.app.GlideApp
import com.skoumal.teanity.ui.ScaleType
import com.skoumal.teanity.ui.applyTransformation

@BindingAdapter("url", "transformation", requireAll = false)
fun setImageFromUrl(view: ImageView, url: String?, transformation: ScaleType? = null) {
    if (url.isNullOrBlank()) {
        return
    }

    val options = RequestOptions().also {
        if (transformation != null) {
            it.applyTransformation(transformation)
        }
    }

    GlideApp.with(view.context)
        .load(url)
        .apply(options)
        .into(view)
}