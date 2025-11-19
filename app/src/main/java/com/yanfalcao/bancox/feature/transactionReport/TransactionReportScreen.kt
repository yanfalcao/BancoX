package com.yanfalcao.bancox.feature.transactionReport

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.yanfalcao.bancox.R
import com.yanfalcao.bancox.feature.transactionReport.widget.BackgroundReport
import com.yanfalcao.bancox.feature.transactionReport.widget.Header
import com.yanfalcao.bancox.feature.transactionReport.widget.TransactionList
import com.yanfalcao.bancox.ui.components.UiSettingsDialog
import com.yanfalcao.bancox.ui.theme.CustomTheme

@Composable
internal fun TransactionReportRoute() {
    TransactionReportScreen()
}

@Composable
fun TransactionReportScreen() {
    var openSettingsDialog by remember { mutableStateOf(false) }

    Scaffold { padding ->
        BackgroundReport(
            Modifier.padding(padding)
        ) {
            Column(
                Modifier
                    .padding(top = 32.dp)
            ) {
                Header(
                    title = "Transações",
                    modifier = Modifier.padding(horizontal = 24.dp),
                    onClickSettings = {
                        openSettingsDialog = true
                    }
                )

                Image(
                    painter = painterResource(R.drawable.ic_card_visa),
                    contentDescription = null,
                    contentScale = ContentScale.Fit,
                    modifier = Modifier.fillMaxWidth()
                        .padding(horizontal = 24.dp)
                        .padding(top = 24.dp)
                        .align(Alignment.CenterHorizontally)
                )

                TransactionList(
                    modifier = Modifier
                        .padding(horizontal = 24.dp)
                        .padding(top = 24.dp)
                )
            }
        }
    }

    if (openSettingsDialog) {
        UiSettingsDialog(
            onDismissRequest = { openSettingsDialog = false },
            onOptionSelected = { option ->

            }
        )
    }
}

@Preview
@Composable
fun Preview() {
    CustomTheme(
        dynamicColor = false
    ) {
        TransactionReportScreen()
    }
}