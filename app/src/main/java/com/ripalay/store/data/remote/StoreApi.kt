package com.ripalay.store.data.remote

import com.ripalay.store.data.remote.models.Caps
import com.ripalay.store.data.remote.models.Register
import com.ripalay.store.data.remote.models.Tokens
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface StoreApi {
    @GET("api/v1/caps/")
    suspend fun getCaps(): Response<Caps>

    @GET("api/v1/caps/")
    suspend fun getCapsId(
        @Query("id") id: String
    ): Response<Caps>

    @POST("auth/users/")
    suspend fun postRegister(
        @Body register: Register
    ): Response<Register>

    @POST("auth/jwt/create/")
    suspend fun postLogin(
        @Body register: Register
    ): Response<Tokens>
}