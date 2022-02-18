package com.ripalay.store.data.remote.models

data class Result(
    val brand: Int?,
    val created: String?,
    val description: String?,
    val id: Int?,
    val image: String?,
    val name: String?,
    val price: Double?,
    val size: List<Int>?,
    val updated: String?,
    var isFavorite: Boolean = false
)