package com.ripalay.store.data.remote.models

import java.io.Serializable

data class Order(
    var id: Int = UNDEFINED,
    var date: String,
    var status: String
) : Serializable {
    companion object {
        const val UNDEFINED = 0
    }
}