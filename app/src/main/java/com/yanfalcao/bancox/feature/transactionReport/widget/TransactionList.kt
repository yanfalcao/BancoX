package com.yanfalcao.bancox.feature.transactionReport.widget

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.yanfalcao.bancox.ui.theme.CustomTheme

@Composable
fun TransactionList() {

}

@Preview
@Composable
fun TransactionListPreview() {
    CustomTheme(
       dynamicColor = false
    ) {
        TransactionList()
    }
}