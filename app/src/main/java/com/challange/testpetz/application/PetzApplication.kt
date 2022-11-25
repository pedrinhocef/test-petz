package com.challange.testpetz.application

import android.app.Application
import com.challange.cache.init.ModuleHawk
import com.challange.homecards.di.startKoin

class PetzApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        ModuleHawk.init(this)
        startKoin(this)
    }
}