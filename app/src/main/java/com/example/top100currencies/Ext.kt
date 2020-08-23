package com.example.top100currencies

import java.text.SimpleDateFormat
import java.util.*

//форматирование чисел . Будем использовать в списке криптовалют для
//   разделения порядков в числах на графике
fun Float.formatThousands() : String {
    val sb = StringBuilder()
    val formatter = Formatter(sb, Locale.US)
    formatter.format("%(,.0f", this)
    return sb.toString()
}


//форматирование дат. Для перевода дат из UNIX в строковый формат  на графике
fun Number.dateToString(pattern: String): String {
    val calendar = Calendar.getInstance()
    calendar.timeInMillis = this.toLong()
    return SimpleDateFormat(pattern).format(calendar.time)
}
