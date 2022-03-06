package com.ripalay.store.ui.sign_up

import androidx.lifecycle.LiveData
import com.ripalay.store.core.network.result.Resource
import com.ripalay.store.core.ui.BaseViewModel
import com.ripalay.store.data.remote.models.Caps
import com.ripalay.store.data.remote.models.Register
import com.ripalay.store.repository.Repository

class SignUpViewModel(private val repository: Repository) : BaseViewModel() {

    fun postRegister(register: Register): LiveData<Resource<Register>> {
        return repository.postRegister(register)
    }
}