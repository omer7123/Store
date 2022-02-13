package com.ripalay.store.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.liveData
import com.ripalay.store.core.network.result.Resource
import com.ripalay.store.data.remote.RemoteDataSource
import com.ripalay.store.data.remote.models.Caps
import kotlinx.coroutines.Dispatchers

class Repository(private val dataSource: RemoteDataSource) {
    fun getCaps(): LiveData<Resource<Caps>> = liveData(Dispatchers.IO) {
        emit(Resource.loading())
        val response = dataSource.getCaps()
        emit(response)
    }

    fun getCapsID(id:String) : LiveData<Resource<Caps>> = liveData(Dispatchers.IO){
        emit(Resource.loading())
        val response = dataSource.getCapsId(id)
        emit(response)
    }
}