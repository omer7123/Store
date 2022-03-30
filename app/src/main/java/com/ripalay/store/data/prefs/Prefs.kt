package com.ripalay.store.data.prefs

import android.content.Context
import android.content.SharedPreferences

class Prefs(context: Context) {
    private var preferences: SharedPreferences? = context.getSharedPreferences("settings", Context.MODE_PRIVATE)
    private var image: String? = null
    private var name: String? = null


//    preferences = context.getSharedPreferences("settings", Context.MODE_PRIVATE)

    fun saveAccess(access: String) {
        preferences!!.edit().putString("access", access).apply()
    }

    fun getAccess(): String? {
        return preferences!!.getString("access", "false")
    }


}