package com.ripalay.store.data.remote.models

data class Register(
    val id: Int,
    val email: String,
    val username: String,
    val password: String,
    val password2: String,
)
