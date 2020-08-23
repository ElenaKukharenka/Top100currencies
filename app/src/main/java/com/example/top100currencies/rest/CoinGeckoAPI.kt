package com.example.top100currencies.rest

import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface CoinGeckoApi {

    //запрос списка криптовалют
    //GET - аннотация функции запроса , в скобках - относительный URL
    //"coins/markets" - название таблицы на сайте, где берем данные
    @GET("coins/markets")
    fun getCoinMarket(
        //переменные параметров со значениями
        // "vs_currency", "per_page", "sparkline", "order" - названия параметров с сайта
        @Query("vs_currency") vs: String = "usd",
        @Query("per_page") perPage: Int = 100,
        @Query("sparkline") sparkline: Boolean = false,
        @Query("order") order: String = "market_cap_desc"
    ): Observable<List<GeckoCoin>>


    //запрос данных для графика
    @GET("coins/{id}/market_chart")
    fun getCoinMarketChart(
        //Path - переменная для подстановки параметра в URL , id валюты
        @Path("id") id: String,
        @Query("vs_currency") vsCurrency: String = "usd",
        @Query("days") days: String = "max"
    ): Observable<GeckoCoinChart>

}