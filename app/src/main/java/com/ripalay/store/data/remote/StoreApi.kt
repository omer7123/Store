package com.ripalay.store.data.remote

import android.provider.ContactsContract
import com.ripalay.store.data.remote.models.Caps
import com.ripalay.store.data.remote.models.Register
import retrofit2.Response
import retrofit2.http.*

interface StoreApi {
    @GET("caps/")
    suspend fun getCaps(): Response<Caps>

    @GET("caps/")
    suspend fun getCapsId(
        @Query("id") id: String
    ): Response<Caps>

    @POST("auth/users/")
    suspend fun postRegister(
        @Body register: Register
    ): Response<Register>

    @POST("users/login/")
    suspend fun postLogin(
        @Body register: Register
    ): Response<String>
}