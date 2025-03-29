package com.example.a22_appdescuento

import android.app.Application
import com.example.a22_appdescuento.data.AppContainer
import com.example.a22_appdescuento.data.AppDataContainer

class DiscountCalculatorApplication : Application() {
    /**
     * AppContainer instance used by the rest of classes to obtain dependencies
     */
    lateinit var container: AppContainer

    override fun onCreate() {
        super.onCreate()
        container = AppDataContainer(this)
    }
}