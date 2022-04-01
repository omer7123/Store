package com.ripalay.store.data.remote.models

data class BrandsRemote(
    val count: Int,
    val results: List<ResultBrand>
)
data class ResultBrand(
    val id: Int,
    val name: String,
    val icon: String
)
