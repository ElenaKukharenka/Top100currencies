package com.example.top100currencies.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast

import com.example.top100currencies.R
import com.example.top100currencies.adapter.BaseAdapter
import com.example.top100currencies.adapter.CurrenciesAdapter
import com.example.top100currencies.di.App
import com.example.top100currencies.mvp.contract.CurrenciesContract
import com.example.top100currencies.mvp.presenter.CurrenciesPresenter
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

/**
 * A simple [Fragment] subclass.
 */
//класс CurrenciesListFragment наследуем от BaseListFragment , расширяем классом CurrenciesContract.View
class CurrenciesListFragment : BaseListFragment(), CurrenciesContract.View {

    @Inject
    lateinit var presenter: CurrenciesPresenter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_currencies_list, container, false)
    }

    //присоединяем к фрагменту презентер и вызываем его функцию создания списка
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        App.appComponent.inject(this)
        presenter.attach(this)
        presenter.makeList()
    }

    override fun createAdapterInstance(): BaseAdapter<*> {
        return CurrenciesAdapter()
    }

    //добавляем новые элементы в список
    override fun addCurrency(currency: CurrenciesAdapter.Currency) {
        viewAdapter.add(currency)
    }

    //оповещаем адаптер об изменении списка
    override fun notifyAdapter() {
        viewAdapter.notifyDataSetChanged()
    }

    //отображаем прогрессбар
    override fun showProgress() {
        requireActivity().progress.visibility = View.VISIBLE
    }

    //прячем прогрессбар
    override fun hideProgress() {
        requireActivity().progress.visibility = View.INVISIBLE
    }

    //отображаем текст ошибки
    override fun showErrorMessage(error: String?) {
        Toast.makeText(context, error, Toast.LENGTH_SHORT).show()
    }

    //при обновлении списка : очищаем адаптер и сообщаем ему о необходимости обновить список
    override fun refresh() {
        viewAdapter.items.clear()
        viewAdapter.notifyDataSetChanged()
    }

    //чтобы презентер не пересоздавался вместе с фрагментом при повороте экрана,
    //   присоединяем его в onResume
    override fun onResume() {
        super.onResume()
        presenter.attach(this)
    }

    //чтобы презентер не пересоздавался вместе с фрагментом при повороте экрана,
    //   отсоединяем его в onPause
    override fun onPause() {
        super.onPause()
        presenter.detach()
    }

}

