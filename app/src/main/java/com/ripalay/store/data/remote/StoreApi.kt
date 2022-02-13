package com.ripalay.store.data.remote

import com.ripalay.store.data.remote.models.Caps
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface StoreApi {
    @GET("api/v1/caps/")
    suspend fun getCaps():Response<Caps>

    @GET("/api/v1/caps/")
    suspend fun getCapsId(
        @Query("id") id: String
    ):Response<Caps>
}