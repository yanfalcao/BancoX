package com.yanfalcao.bancox.feature.paymentReceipt.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.yanfalcao.bancox.feature.paymentReceipt.PaymentReceiptScreen

const val PAYMENT_RECEIPT_ROUTE = "payment_receipt_screen"

fun NavController.navigateToPaymentReceipt() {
    this.navigate(PAYMENT_RECEIPT_ROUTE)
}

fun NavGraphBuilder.paymentReceiptScreen() {
    composable(PAYMENT_RECEIPT_ROUTE) {
        PaymentReceiptScreen()
    }
}