package com.ripalay.store.di

import com.ripalay.store.core.network.networkModule
import com.ripalay.store.data.remote.remoteDataSource

val koinModules = listOf(
    networkModule,
    remoteDataSource
)