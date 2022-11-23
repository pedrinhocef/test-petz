package com.challange.homecards.di

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin


fun startKoin(application: Application) {
    startKoin {
        androidContext(application.applicationContext)
    }
}