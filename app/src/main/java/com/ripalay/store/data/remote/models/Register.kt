package com.ripalay.store.data.remote.models

data class Register(
    val email: String,
    val username: String,
    val password: String,
)
data class Tokens(
    val refresh: String,
    val access: String
)
