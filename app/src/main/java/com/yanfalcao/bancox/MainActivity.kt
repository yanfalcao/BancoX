package com.yanfalcao.bancox

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.yanfalcao.bancox.feature.transactionReport.navigation.TRANSACTION_REPORT_ROUTE
import com.yanfalcao.bancox.feature.transactionReport.navigation.transactionReportScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val navController = rememberNavController()

            NavHost(
                navController = navController,
                startDestination = TRANSACTION_REPORT_ROUTE,
            ) {
                transactionReportScreen()
            }
        }
    }
}