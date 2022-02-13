package com.ripalay.store.ui.detail_caps_fragment

import androidx.lifecycle.LiveData
import com.ripalay.store.core.network.result.Resource
import com.ripalay.store.core.ui.BaseViewModel
import com.ripalay.store.data.remote.models.Caps
import com.ripalay.store.repository.Repository

class DetailCapsViewModel(private val repository: Repository) : BaseViewModel() {

    fun getCapId(id: String): LiveData<Resource<Caps>> {
        return repository.getCapsID(id)
    }
}