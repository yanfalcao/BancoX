package com.yanfalcao.bancox.feature.transactionReport.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.yanfalcao.bancox.feature.transactionReport.TransactionReportRoute

const val TRANSACTION_REPORT_ROUTE = "transaction_report_screen"

fun NavController.navigateToTransactionReport() {
    this.navigate(TRANSACTION_REPORT_ROUTE)
}

fun NavGraphBuilder.transactionReportScreen() {
    composable(TRANSACTION_REPORT_ROUTE) {
        TransactionReportRoute()
    }
}