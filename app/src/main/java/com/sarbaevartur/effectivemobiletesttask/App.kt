package com.sarbaevartur.effectivemobiletesttask

import android.app.Application
import com.sarbaevartur.effectivemobiletesttask.di.appModule
import com.sarbaevartur.effectivemobiletesttask.di.dataModule
import com.sarbaevartur.effectivemobiletesttask.di.domainModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class App: Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin{
            androidContext(this@App)
            modules(listOf(appModule, domainModule, dataModule))
        }

        configureRetrofit()
    }

    private fun configureRetrofit(){

    }
}