package com.ripalay.store.data.remote

import com.ripalay.store.core.network.BaseDataSource
import com.ripalay.store.data.remote.models.Register
import com.ripalay.store.data.remote.models.User
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

    suspend fun getBrands() = getResult {
        storeApi.getBrands()
    }

    suspend fun getUser(token: String) = getResult {
        storeApi.getUser(token)
    }

    suspend fun updateUser(token: String, userName: String, eMail: String) = getResult {
        storeApi.updateUser(token, userName, eMail)
    }

    suspend fun getCapsBrand(name:String) = getResult {
        storeApi.getCapsBrand(name)
    }
    
}