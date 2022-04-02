package com.ripalay.store.repository

import android.graphics.Paint
import androidx.lifecycle.LiveData
import androidx.lifecycle.liveData
import com.ripalay.store.core.network.result.Resource
import com.ripalay.store.data.remote.RemoteDataSource
import com.ripalay.store.data.remote.models.*
import kotlinx.coroutines.Dispatchers

class Repository(private val dataSource: RemoteDataSource) {
    fun getCaps(): LiveData<Resource<Caps>> = liveData(Dispatchers.IO) {
        emit(Resource.loading())
        val response = dataSource.getCaps()
        emit(response)
    }

    fun getCapsID(id: String): LiveData<Resource<Results>> = liveData(Dispatchers.IO) {
        emit(Resource.loading())
        val response = dataSource.getCapsId(id)
        emit(response)
    }

    fun postRegister(
        register: Register,
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

    fun getBrands(): LiveData<Resource<BrandsRemote>> = liveData(Dispatchers.IO) {
        emit(Resource.loading())
        val response = dataSource.getBrands()
        emit(response)
    }
    
    fun getUser(token: String): LiveData<Resource<User>> = liveData(Dispatchers.IO) {
        emit(Resource.loading())
        val response = dataSource.getUser(token)
        emit(response)
    }

    fun updateUser(token: String, userName: String, eMail: String): LiveData<Resource<User>> =
        liveData(Dispatchers.IO) {
            emit(Resource.loading())
            val response = dataSource.updateUser(token, userName, eMail)
            emit(response)
        }

    fun getCapsBrand(name: String):LiveData<Resource<Caps>> = liveData(Dispatchers.IO){
        emit(Resource.loading())
        val response = dataSource.getCapsBrand(name)
        emit(response)
    }

}
