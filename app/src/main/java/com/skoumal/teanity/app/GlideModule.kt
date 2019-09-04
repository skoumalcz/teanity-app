package com.skoumal.teanity.app

import android.content.Context
import android.util.Log
import com.bumptech.glide.GlideBuilder
import com.bumptech.glide.load.engine.bitmap_recycle.LruBitmapPool
import com.bumptech.glide.load.engine.cache.LruResourceCache
import com.bumptech.glide.module.AppGlideModule
import com.skoumal.teanity.app.data.Constants
import com.bumptech.glide.annotation.GlideModule as ExtGlideModule

@ExtGlideModule
class GlideModule : AppGlideModule() {

    override fun applyOptions(context: Context, builder: GlideBuilder) {
        if (Constants.isDebug) {
            builder.setLogLevel(Log.VERBOSE)
        }

        val memoryCacheSizeBytes = 1024 * 1024 * 20 // 20mb
        builder.setMemoryCache(LruResourceCache(memoryCacheSizeBytes.toLong()))

        val bitmapPoolSizeBytes = 1024 * 1024 * 30 // 30mb
        builder.setBitmapPool(LruBitmapPool(bitmapPoolSizeBytes.toLong()))
    }

}