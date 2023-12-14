package com.D121211077.kapanMatahari

import android.app.Application
import com.D121211077.kapanMatahari.data.AppContainer
import com.D121211077.kapanMatahari.data.DefaultAppContainer

class MyApplication: Application() {

    lateinit var container: AppContainer

    override fun onCreate() {
        super.onCreate()
        container = DefaultAppContainer()
    }

}