package com.ohanahana.cloudcompute

import android.app.Application
import com.ohanahana.cloudcompute.di.initKoin

class SensorDataApp : Application() {
    override fun onCreate() {
        super.onCreate()
        initKoin()
    }
}
