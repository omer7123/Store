package com.ripalay.store.ui.sign_in

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.ripalay.store.core.network.result.Resource
import com.ripalay.store.core.ui.BaseViewModel
import com.ripalay.store.data.remote.models.Register
import com.ripalay.store.data.remote.models.Tokens
import com.ripalay.store.repository.Repository

class SignInViewModel(private val repository: Repository) : BaseViewModel() {

    var loading = MutableLiveData<Boolean>()

    fun postLogin(register: Register): LiveData<Resource<Tokens>> {
        return repository.postLogin(register)
    }
}