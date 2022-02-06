package com.ripalay.store.domain.models

data class Brands(
    var name: String,
    var image: Int,
    var id: Int = UNDEFINED
){
    companion object {
        const val UNDEFINED = 0
    }
}