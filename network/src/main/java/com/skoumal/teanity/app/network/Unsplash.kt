package com.skoumal.teanity.app.network

import com.skoumal.teanity.app.model.inbound.InPhoto
import retrofit2.http.GET
import retrofit2.http.Query

interface Unsplash {

    @GET("photos/")
    suspend fun getPhotos(
        @Query("page") page: Int = 1,
        @Query("per_page") perPage: Int = 10
    ): List<InPhoto>

    companion object {
        const val url = "https://api.unsplash.com"
    }

}