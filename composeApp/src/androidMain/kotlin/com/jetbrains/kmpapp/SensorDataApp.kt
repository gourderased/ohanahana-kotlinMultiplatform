package com.jetbrains.kmpapp

import android.app.Application
import com.jetbrains.kmpapp.di.initKoin

class SensorDataApp : Application() {
    override fun onCreate() {
        super.onCreate()
        initKoin()
    }
}
