package com.ripalay.store.data.remote.models

import com.google.gson.annotations.SerializedName

data class User(
    val id: Int,
    @SerializedName("email")
    val eMail: String,
    @SerializedName("username")
    val userName: String,
)