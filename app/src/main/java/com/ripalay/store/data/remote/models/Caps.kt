package com.ripalay.store.data.remote.models

data class Caps(
    val image: String,
    val count: Int?,
    val next: Any?,
    val previous: Any?,
    val results: List<Result>?
)