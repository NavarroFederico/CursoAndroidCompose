package com.example.a18_marsphotos

import android.app.Application
import com.example.a18_marsphotos.data.AppContainer
import com.example.a18_marsphotos.data.DefaultAppContainer

class MarsPhotosApplication : Application() {
lateinit var container: AppContainer
override fun onCreate() {
    super.onCreate()
    container = DefaultAppContainer()
}

}