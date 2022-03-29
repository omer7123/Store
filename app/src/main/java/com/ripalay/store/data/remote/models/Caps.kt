package com.ripalay.store.data.remote.models

data class Caps(
    val price: Int,
    val count: Int?,
    val next: Any?,
    val previous: Any?,
    val results: List<Results>?
)