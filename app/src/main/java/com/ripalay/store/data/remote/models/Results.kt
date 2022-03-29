package com.ripalay.store.data.remote.models

import com.google.gson.annotations.SerializedName

data class Results(
    val id: Int?,
    val brand: String?,
    val name: String?,
    val price: Int?,
    @SerializedName("new_price")
    val newPrice: Int,
    @SerializedName("capsimage")
    val capsImage: String?,

    val created: String?,
    val description: String?,

    val size: List<Int>?,
    val updated: String?,
    var isFavorite: Boolean = false
)