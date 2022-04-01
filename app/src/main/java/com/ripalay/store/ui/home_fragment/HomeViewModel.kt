package com.ripalay.store.ui.home_fragment

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.ripalay.store.core.network.result.Resource
import com.ripalay.store.core.ui.BaseViewModel
import com.ripalay.store.data.remote.models.BrandsRemote
import com.ripalay.store.data.remote.models.Caps
import com.ripalay.store.repository.Repository

class HomeViewModel(private val repository: Repository) : BaseViewModel() {
    var loading = MutableLiveData<Boolean>()

    fun getCaps(): LiveData<Resource<Caps>> {
        return repository.getCaps()
    }

    fun getCapsBrand(): LiveData<Resource<BrandsRemote>>{
        return repository.getBrands()
    }


}