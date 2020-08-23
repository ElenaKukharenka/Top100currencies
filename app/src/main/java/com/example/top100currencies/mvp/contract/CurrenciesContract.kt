package com.example.top100currencies.mvp.contract

import com.example.top100currencies.adapter.CurrenciesAdapter
import com.example.top100currencies.mvp.contract.BaseContract

//наследуем от базового класса
class CurrenciesContract {
    // интерфейс View содержит функции добавления новых валют в список,
    //   оповещения адаптера об изменениях списка, отображения/скрытия прогрессбара,
    //   отображения ошибки , функцию обновления
    interface View : BaseContract.View {
        fun addCurrency(currency: CurrenciesAdapter.Currency)
        fun notifyAdapter()
        fun showProgress()
        fun hideProgress()
        fun showErrorMessage(error: String?)
        fun refresh()
    }

    //Презентер содержит функции создания и обновления списка валют
    abstract class Presenter: BaseContract.Presenter<View>() {
        abstract fun makeList()
        abstract fun refreshList()
    }
}