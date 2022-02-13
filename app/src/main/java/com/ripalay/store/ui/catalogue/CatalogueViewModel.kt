package com.ripalay.store.ui.catalogue

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.ripalay.store.core.network.result.Resource
import com.ripalay.store.core.ui.BaseViewModel
import com.ripalay.store.data.remote.models.Caps
import com.ripalay.store.repository.Repository

class CatalogueViewModel(private val repository: Repository) : BaseViewModel() {

    var loading = MutableLiveData<Boolean>()

    fun getCaps(): LiveData<Resource<Caps>> {
        return repository.getCaps()
    }
}