package com.ripalay.store.data.remote

import com.ripalay.store.core.network.BaseDataSource
import com.ripalay.store.data.remote.models.Register
import org.koin.dsl.module

val remoteDataSource = module {
    factory { RemoteDataSource(get()) }
}

class RemoteDataSource(private val storeApi: StoreApi) : BaseDataSource() {

    suspend fun getCaps() = getResult {
        storeApi.getCaps()
    }

    suspend fun getCapsId(id: String) = getResult {
        storeApi.getCapsId(id)
    }

    suspend fun postRegister(register: Register) = getResult {
        storeApi.postRegister(register)
    }

    suspend fun postLogin(register: Register) = getResult {
        storeApi.postLogin(register)
    }
}