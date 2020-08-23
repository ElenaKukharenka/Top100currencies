package com.example.top100currencies.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView

//абстрактный базовый класс адаптера
abstract class BaseAdapter<VH : BaseAdapter.BaseViewHolder> : RecyclerView.Adapter<VH>() {

    //список элементов ArrayList
    var items : ArrayList<Any> = ArrayList()

    //возвращает размер списка
    override fun getItemCount(): Int {
        return items.size
    }

    //связывает views с содержимым
    override fun onBindViewHolder(holder: VH, position: Int) {
        holder.bind(getItem(position))
    }

    //возвращает позицию элемента в списке
    fun getItem(position: Int): Any {
        return items[position]
    }

    //добавление одного элемента
    fun add(newItem: Any) {
        items.add(newItem)
    }

   //добавление всех элементов
    fun add(newItems: List<Any>) {
        items.addAll(newItems)
    }

    //абстрактный класс ViewHolder
    abstract class BaseViewHolder(protected val view: View) : RecyclerView.ViewHolder(view) {
        abstract fun bind(item: Any)
    }
}