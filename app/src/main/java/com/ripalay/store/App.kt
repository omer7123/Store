package com.ripalay.store

import android.app.Application
import com.ripalay.store.di.koinModules
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class App : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@App)
            modules(koinModules)
        }
    }
}