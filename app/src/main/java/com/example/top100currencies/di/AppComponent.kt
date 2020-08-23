package com.example.top100currencies.di

import com.example.top100currencies.activities.ChartActivity
import com.example.top100currencies.activities.MainActivity
import com.example.top100currencies.chart.LatestChart
import com.example.top100currencies.fragments.CurrenciesListFragment
import com.example.top100currencies.mvp.presenter.CurrenciesPresenter
import com.example.top100currencies.mvp.presenter.LatestChartPresenter
import dagger.Component

import javax.inject.Singleton

//@Component говорит Даггеру, что AppComponent содержит 4 модуля
//зависимости , которые провайдит каждый из этих модулей , доступны для всех остальных модулей ,
// объединенных в компоненте AppComponent
@Component(modules = arrayOf(AppModule::class, RestModule::class, MvpModule::class, ChartModule::class))
@Singleton
interface AppComponent {

    fun inject(mainActivity: MainActivity)

    fun inject(fragment: CurrenciesListFragment)

    fun inject(presenter: CurrenciesPresenter)
    fun inject(presenter: LatestChartPresenter)

    fun inject(chart: LatestChart)
    fun inject(activity: ChartActivity)


}