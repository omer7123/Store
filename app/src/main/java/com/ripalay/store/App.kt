package com.ripalay.store

import android.app.Application
import androidx.room.Room
import com.ripalay.store.data.local.room.AppDataBase
import com.ripalay.store.di.koinModules
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class App : Application() {

    var instance: App? = null
    private var database: AppDataBase? = null


    override fun onCreate() {
        super.onCreate()
        instance = this
        database = Room
            .databaseBuilder(this, AppDataBase::class.java, "database.db")
            .allowMainThreadQueries()
            .build()

        startKoin {
            androidContext(this@App)
            modules(koinModules)
        }
    }

    @JvmName("getInstance1")
    fun getInstance(): App? {
        return instance
    }

    fun getDatabase(): AppDataBase? {
        return database
    }
}