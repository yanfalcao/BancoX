package com.yanfalcao.bancox.utils

import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

object Format {
    fun formatCurrency(value: Double): String {
        return "R$ %.2f".format(value).replace('.', ',')
    }

    fun formatDayMonthYear(date: LocalDateTime): String {
        val format = DateTimeFormatter.ofPattern("dd/MM/yyyy")
        return date.format(format)
    }
}