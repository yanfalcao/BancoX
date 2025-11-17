package com.yanfalcao.bancox.feature.transactionReport

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clipToBounds
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.yanfalcao.bancox.R
import com.yanfalcao.bancox.feature.transactionReport.widget.BackgroundReport
import com.yanfalcao.bancox.feature.transactionReport.widget.Header
import com.yanfalcao.bancox.feature.transactionReport.widget.TransactionList
import com.yanfalcao.bancox.ui.theme.CustomTheme

@Composable
internal fun TransactionReportRoute() {
    TransactionReportScreen()
}

@Composable
fun TransactionReportScreen() {
    Scaffold { padding ->
        BackgroundReport(
            Modifier.padding(padding)
        ) {
            Column(
                Modifier
                    .padding(top = 32.dp)
            ) {
                Header(
                    "Transações",
                    Modifier.padding(horizontal = 24.dp)
                )

                Image(
                    painter = painterResource(R.drawable.ic_card_visa),
                    contentDescription = null,
                    contentScale = ContentScale.FillWidth,
                    modifier = Modifier.fillMaxWidth()
                        .padding(horizontal = 24.dp)
                        .padding(top = 24.dp)
                )

                TransactionList(
                    modifier = Modifier
                        .padding(horizontal = 24.dp)
                        .padding(top = 24.dp)
                )
            }
        }
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