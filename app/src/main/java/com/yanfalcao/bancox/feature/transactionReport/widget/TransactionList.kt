package com.yanfalcao.bancox.feature.transactionReport.widget

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.yanfalcao.bancox.model.ColorThemeOptions
import com.yanfalcao.bancox.model.MockTransactions
import com.yanfalcao.bancox.model.getColorIcon
import com.yanfalcao.bancox.model.getColorIconBackground
import com.yanfalcao.bancox.ui.components.TransactionRow
import com.yanfalcao.bancox.ui.theme.CustomTheme
import com.yanfalcao.bancox.utils.Format
import java.time.LocalDateTime

@Composable
fun TransactionList(
    modifier: Modifier = Modifier,
) {
    var referenceDate = Format.formatDayMonthYear(LocalDateTime.now().plusDays(1))
    LazyColumn(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        items(items = MockTransactions(), key = { it.id }) {
            val date = Format.formatDayMonthYear(it.paidAt)

            if(!referenceDate.equals(date)) {
                Text(it.paidAtFormatted,
                    style = MaterialTheme.typography.labelLarge.copy(
                        color = MaterialTheme.colorScheme.onSurface
                    ),
                    modifier = Modifier.padding(bottom = 8.dp)
                )
                referenceDate = date
            }


            TransactionRow(
                title = it.name,
                subtitle = it.successFormatted,
                transactionValue = it.amount,
                icon = painterResource(it.icon),
                iconColor = it.type.getColorIcon(),
                iconBackgroundColor = it.type.getColorIconBackground(),
                Modifier.padding(bottom = 16.dp)
            )

            Box(
                Modifier
                    .fillMaxWidth()
                    .height(1.dp)
                    .background(MaterialTheme.colorScheme.outline)
            )
        }
    }
}

@Preview
@Composable
fun TransactionListPreview() {
    CustomTheme(
        ColorThemeOptions.System
    ) {
        TransactionList(
            Modifier.background(MaterialTheme.colorScheme.background)
        )
    }
}