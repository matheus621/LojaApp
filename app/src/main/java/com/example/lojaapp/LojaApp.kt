package com.example.lojaapp

import android.app.Application
import com.example.lojaapp.di.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class LojaApp : Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger()
            androidContext(this@LojaApp)
            modules(appModule)
        }
    }
}