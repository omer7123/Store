package com.ripalay.store.data.remote

import com.ripalay.store.data.remote.models.Caps
import retrofit2.Response
import retrofit2.http.GET

interface StoreApi {
    @GET("api/v1/caps/")
    suspend fun getCaps():Response<Caps>
}