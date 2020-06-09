package com.skoumal.teanity.app.data

import androidx.paging.PagedList
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.launch

abstract class RationalBoundaryCallback<Item> : PagedList.BoundaryCallback<Item>(),
    CoroutineScope by MainScope() {

    abstract suspend fun getOffsetOf(item: Item): Int
    abstract suspend fun fetchMore(offset: Int)

    private var actingJob: Job? = null
        @Synchronized set(value) {
            if (field?.isActive == true || value == null) {
                return
            }
            field = value
        }

    override fun onZeroItemsLoaded() {
        actingJob = scheduleAsync { fetchMore(0) }
    }

    override fun onItemAtEndLoaded(itemAtEnd: Item) {
        actingJob = scheduleAsync { fetchMore(getOffsetOf(itemAtEnd)) }
    }

    override fun onItemAtFrontLoaded(itemAtFront: Item) {
        //actingJob = scheduleAsync { fetchMore(0) }
    }

    private inline fun scheduleAsync(crossinline body: suspend CoroutineScope.() -> Unit): Job? {
        val currentJob = actingJob
        if (currentJob != null && currentJob.isActive) {
            return null
        }
        return launch { body() }
    }

}