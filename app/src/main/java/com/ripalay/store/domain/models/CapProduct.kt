package com.ripalay.store.domain.models

data class CapProduct(
    var name: String,
    var image: Int,
    var brand: String,
    var price: Int,
    var liked: Boolean,
    var oldPrice: Int,
    var id: Int = UNDEFINED
){
    companion object {
        const val UNDEFINED = 0
    }
}