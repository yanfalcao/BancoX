package com.yanfalcao.bancox.model

import androidx.annotation.DrawableRes
import com.yanfalcao.bancox.R
import com.yanfalcao.bancox.ui.theme.GovernorBay
import com.yanfalcao.bancox.ui.theme.RadicalRed
import com.yanfalcao.bancox.ui.theme.Viking
import com.yanfalcao.bancox.utils.Format
import java.time.LocalDateTime
import java.util.UUID

data class Transaction(
    val id: String = UUID.randomUUID().toString(),
    val name: String,
    val success: Boolean,
    val amount: Double,
    val paidAt: LocalDateTime,
    val code: String,
    val from: String,
    val type: TransactionTypeEnum,
    @DrawableRes val icon: Int,
) {
    val successFormatted: String
        get() = if (success) "Pago com sucesso" else "Falha no pagamento"

    val paidAtFormatted: String
        get() {
            val date = Format.formatDayMonthYear(paidAt)

            return when(date) {
                Format.formatDayMonthYear(LocalDateTime.now()) -> {
                    "Hoje"
                }
                Format.formatDayMonthYear(LocalDateTime.now().minusDays(1)) -> {
                    "Ontem"
                }
                else -> {
                    date
                }
            }
        }
}

fun MockTransactions() = listOf(
    Transaction(
        name = "Supermercado",
        success = true,
        amount = -650.75,
        paidAt = LocalDateTime.now(),
        code = "TXN1234A6",
        from = "Lojas Americanas",
        icon = R.drawable.ic_receipt_list,
        type = TransactionTypeEnum.FOOD,
    ),
    Transaction(
        name = "Conta de Energia",
        success = true,
        amount = -235.50,
        paidAt = LocalDateTime.now().minusDays(1),
        code = "TXN1243457",
        from = "Coelba",
        icon = R.drawable.ic_socket,
        type = TransactionTypeEnum.BILL,
    ),
    Transaction(
        name = "Conta de Água",
        success = true,
        amount = -85.50,
        paidAt = LocalDateTime.now().minusDays(1),
        code = "TXN123957",
        from = "Embasa",
        icon = R.drawable.ic_water_drop,
        type = TransactionTypeEnum.BILL,
    ),
    Transaction(
        name = "Salário",
        success = true,
        amount = 5500.00,
        paidAt = LocalDateTime.now().minusDays(10),
        code = "TXN723457",
        from = "Empresa S.A.",
        icon = R.drawable.ic_income,
        type = TransactionTypeEnum.SALARY
    ),
    Transaction(
        name = "Stream",
        success = false,
        amount = -12.99,
        paidAt = LocalDateTime.now().minusDays(15),
        code = "TXN123G58",
        from = "Netflix",
        icon = R.drawable.ic_receipt_list,
        type = TransactionTypeEnum.ENTERTAINMENT
    ),
    Transaction(
        name = "Restaurante",
        success = true,
        amount = -120.00,
        paidAt = LocalDateTime.now().minusDays(19),
        code = "TXN12J459",
        from = "Outback",
        icon = R.drawable.ic_receipt_list,
        type = TransactionTypeEnum.FOOD
    ),
)