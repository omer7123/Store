package com.ripalay.store.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.liveData
import com.ripalay.store.core.network.result.Resource
import com.ripalay.store.data.remote.RemoteDataSource
import com.ripalay.store.data.remote.models.Caps
import com.ripalay.store.data.remote.models.Register
import com.ripalay.store.data.remote.models.Tokens
import kotlinx.coroutines.Dispatchers

class Repository(private val dataSource: RemoteDataSource) {
    fun getCaps(): LiveData<Resource<Caps>> = liveData(Dispatchers.IO) {
        emit(Resource.loading())
        val response = dataSource.getCaps()
        emit(response)
    }

    fun getCapsID(id: String): LiveData<Resource<Caps>> = liveData(Dispatchers.IO) {
        emit(Resource.loading())
        val response = dataSource.getCapsId(id)
        emit(response)
    }

    fun postRegister(
        register: Register
    ): LiveData<Resource<Register>> = liveData(Dispatchers.IO) {
        emit(Resource.loading())
        val response = dataSource.postRegister(register)
        emit(response)
    }

    fun postLogin(register: Register): LiveData<Resource<Tokens>> = liveData(Dispatchers.IO) {
        emit(Resource.loading())
        val response = dataSource.postLogin(register)
        emit(response)
    }
}