package com.example.a20_bookshelf

import android.app.Application
import com.example.a20_bookshelf.data.AppContainer
import com.example.a20_bookshelf.data.DefaultAppContainer

class BookshelfApplication : Application() {
    lateinit var container: AppContainer
    override fun onCreate() {
        super.onCreate()
        container = DefaultAppContainer()
    }
}