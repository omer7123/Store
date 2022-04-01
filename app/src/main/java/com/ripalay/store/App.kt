package com.ripalay.store

import android.app.Application
import androidx.room.Room
import com.ripalay.store.data.local.room.AppDataBase
import com.ripalay.store.di.koinModules
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class App : Application() {

    private lateinit var instance: App
//    private lateinit var database: AppDataBase


    override fun onCreate() {
        super.onCreate()
        database = Room
            .databaseBuilder(applicationContext, AppDataBase::class.java, "database.db")
            .allowMainThreadQueries()
            .build()

        startKoin {
            androidContext(this@App)
            modules(koinModules)
        }
    }

    companion object {
        lateinit var database: AppDataBase
        lateinit var instance: App
    }



}