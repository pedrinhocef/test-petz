package com.challange.cache.init

import android.content.Context
import com.orhanobut.hawk.Hawk

object ModuleHawk {

    fun init(context: Context) {
        Hawk.init(context).build()
    }

    fun contains(key: String): Boolean {
        return Hawk.contains(key)
    }

    fun <T> get(key: String): T = Hawk.get(key)

    fun <T> put(key: String, value: T) = Hawk.put(key, value)

    fun delete(key: String) {
        if (Hawk.contains(key)) {
            Hawk.delete(key)
        }
    }

    fun deleteAll() = Hawk.deleteAll()
}