package com.ripalay.store.ui.sign_in

import androidx.lifecycle.LiveData
import com.ripalay.store.core.network.result.Resource
import com.ripalay.store.core.ui.BaseViewModel
import com.ripalay.store.data.remote.models.Register
import com.ripalay.store.repository.Repository

class SignInViewModel(private val repository: Repository): BaseViewModel() {

    fun postLogin(register: Register):LiveData<Resource<String>>{
        return repository.postLogin(register)
    }
}