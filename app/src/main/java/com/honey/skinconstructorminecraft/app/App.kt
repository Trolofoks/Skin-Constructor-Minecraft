package com.honey.skinconstructorminecraft.app

import android.app.Application
import com.honey.skinconstructorminecraft.di.appModule
import com.honey.skinconstructorminecraft.di.dataModule
import com.honey.skinconstructorminecraft.di.domainModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class App : Application() {


    override fun onCreate() {
        super.onCreate()
        startKoin{
            androidLogger(Level.ERROR)
            androidContext(this@App)
            modules(modules)
        }
    }
}

val modules = listOf(
    appModule,
    domainModule,
    dataModule
)