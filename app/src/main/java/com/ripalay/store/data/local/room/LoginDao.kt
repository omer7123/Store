package com.ripalay.store.data.local.room

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.ripalay.store.data.remote.models.Register

@Dao
interface LoginDao {

    @Insert
    fun addLoginItem(login: Register)

    @Query("SELECT * FROM login_items")
    fun getLogin(): LiveData<Register>

}