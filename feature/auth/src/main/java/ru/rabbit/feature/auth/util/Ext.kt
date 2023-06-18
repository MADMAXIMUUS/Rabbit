package ru.rabbit.feature.auth.util

import java.text.SimpleDateFormat
import java.util.*

fun Long.toCalendarDate(): String {
    val sdf = SimpleDateFormat("dd MMMM yyyy", Locale("ru"))
    sdf.timeZone = TimeZone.getDefault()
    val netDate = Date(this)
    return sdf.format(netDate)
}