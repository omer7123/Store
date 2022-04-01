package com.ripalay.store.data.remote.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "login_items")
data class Register(
    @PrimaryKey(autoGenerate = true)
    val id: Int?,
    val email: String,
    val username: String,
    val password: String,
)
data class Tokens(
    val refresh: String,
    val access: String
)
