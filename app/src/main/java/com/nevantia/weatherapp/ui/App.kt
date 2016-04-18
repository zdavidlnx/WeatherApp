package com.nevantia.weatherapp.ui

import android.app.Application

/**
 * Created by d_garcia on 18/04/2016.
 */

class App: Application() {

    companion object {
        lateinit var instance: App
            private set
    }


    override fun onCreate() {
        super.onCreate()
        instance = this
    }
}
