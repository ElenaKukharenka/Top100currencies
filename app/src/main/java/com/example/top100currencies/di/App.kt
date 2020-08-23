package com.example.top100currencies.di

import android.app.Application
class App : Application() {

    companion object {
        lateinit var appComponent: AppComponent
    }

    //инициализируем Dagger
    override fun onCreate() {
        super.onCreate()
        initializeDagger()
    }

    private fun initializeDagger() {
        appComponent = DaggerAppComponent.builder()
            .appModule(AppModule(this))
            .restModule(RestModule())
            .mvpModule(MvpModule())
            .chartModule(ChartModule())
            .build()
    }
}