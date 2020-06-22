package com.skoumal.teanity.app.model.recyclable

import androidx.recyclerview.widget.DiffUtil
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

suspend inline fun DiffUtil.Callback.calculateDiff() = withContext(Dispatchers.Default) {
    DiffUtil.calculateDiff(this@calculateDiff)
}