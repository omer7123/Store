package com.ripalay.store.data.remote

import com.ripalay.store.core.network.BaseDataSource
import org.koin.dsl.module

val remoteDataSource = module {
    factory { RemoteDataSource(get()) }
}

class RemoteDataSource(private val storeApi: StoreApi) : BaseDataSource() {

    suspend fun getCaps() = getResult {
        storeApi.getCaps()
    }

    suspend fun getCapsId(id:String) = getResult {
        storeApi.getCapsId(id)
    }
}