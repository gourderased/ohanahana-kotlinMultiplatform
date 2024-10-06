package com.ohana.cloudcompute

import android.app.Application
import com.ohana.cloudcompute.di.initKoin

class SensorDataApp : Application() {
    override fun onCreate() {
        super.onCreate()
        initKoin()
    }
}
