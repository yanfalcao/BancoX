package com.yanfalcao.bancox.utils

object Format {
    fun formatCurrency(value: Double): String {
        return "R$ %.2f".format(value).replace('.', ',')
    }
}