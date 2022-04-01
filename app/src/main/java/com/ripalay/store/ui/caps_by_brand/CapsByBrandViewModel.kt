package com.ripalay.store.ui.caps_by_brand

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.ripalay.store.core.network.result.Resource
import com.ripalay.store.core.ui.BaseViewModel
import com.ripalay.store.data.remote.models.Caps
import com.ripalay.store.repository.Repository

class CapsByBrandViewModel(private val repository: Repository): BaseViewModel() {

    val loading = MutableLiveData<Boolean>()

    fun getCapsBrand(name:String): LiveData<Resource<Caps>>{
        return repository.getCapsBrand(name)
    }
}