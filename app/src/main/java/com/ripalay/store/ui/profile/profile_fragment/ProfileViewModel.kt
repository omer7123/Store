package com.ripalay.store.ui.profile.profile_fragment

import androidx.lifecycle.LiveData
import com.ripalay.store.core.network.result.Resource
import com.ripalay.store.core.ui.BaseViewModel
import com.ripalay.store.data.remote.models.User
import com.ripalay.store.repository.Repository

class ProfileViewModel(private val repository: Repository) : BaseViewModel() {

    fun getUser(token: String): LiveData<Resource<User>> {
        return repository.getUser(token)
    }

    fun updateUser(token: String, userName: String, eMail: String): LiveData<Resource<User>> {
        return repository.updateUser(token, userName, eMail)
    }

}