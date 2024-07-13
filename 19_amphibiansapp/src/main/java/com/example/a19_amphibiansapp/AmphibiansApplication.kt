package com.example.a19_amphibiansapp

import android.app.Application
import com.example.a19_amphibiansapp.data.AppContainer
import com.example.a19_amphibiansapp.data.DefaultAppContainer

class AmphibiansApplication : Application() {
    lateinit var container: AppContainer
    override fun onCreate() {
        super.onCreate()
        container = DefaultAppContainer()
    }
}