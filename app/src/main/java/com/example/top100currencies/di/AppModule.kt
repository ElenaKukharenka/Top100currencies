package com.example.top100currencies.di

import android.content.Context
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

//класс AppModule будет предоставлять контекст для доступа к ресурсам в любой части приложения
//аннотация @Module сообщает Даггеру , что функции этого класса предоставляют зависимости
@Module
class AppModule (private val app: App) {

    //функция provideContext помечена аннотацией @Provides - предоставляет зависимость
    @Provides
    //аннотация @Singleton означает , что Даггер при инициализации компонента создаст
    //   единственный  экземпляр этой зависимости. И при каждом обращении к этой зависимости
    //   будет предоставляться этот единственный экземпляр . Это позволяет избежать
    //   ненужного пересоздания объектов , утечек памяти и др.проблем
    @Singleton
    fun provideContext(): Context = app
}