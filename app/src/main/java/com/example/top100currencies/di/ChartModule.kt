package com.example.top100currencies.di

import com.example.top100currencies.chart.LatestChart
import com.example.top100currencies.formatter.YearValueFormatter
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

//для работы с графиком
@Module
class ChartModule {
    @Provides
    @Singleton
    fun provideLatestChart() = LatestChart()



    @Provides
    @Singleton
    fun provideYearFormatter() = YearValueFormatter()

}