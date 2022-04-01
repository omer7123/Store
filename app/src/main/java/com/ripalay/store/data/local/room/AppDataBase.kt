package com.ripalay.store.data.local.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.ripalay.store.data.remote.models.Register


@Database(entities = [Register::class], version = 1)
abstract class AppDataBase : RoomDatabase() {

    abstract fun loginDao(): LoginDao

}