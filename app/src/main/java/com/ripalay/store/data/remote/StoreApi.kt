package com.ripalay.store.data.remote

import com.ripalay.store.data.remote.models.*
import retrofit2.Response
import retrofit2.http.*

interface StoreApi {
    @GET("api/v1/caps/")
    suspend fun getCaps(): Response<Caps>

    @GET("api/v1/caps/{id}/")
    suspend fun getCapsId(
        @Path("id") id: String
    ): Response<Results>

    @POST("auth/users/")
    suspend fun postRegister(
        @Body register: Register
    ): Response<Register>

    @POST("auth/jwt/create/")
    suspend fun postLogin(
        @Body register: Register
    ): Response<Tokens>

    @GET("api/v1/caps/brand/")
    suspend fun getBrands(): Response<BrandsRemote>
}