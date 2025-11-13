package com.yanfalcao.bancox.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredSizeIn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.yanfalcao.bancox.R
import com.yanfalcao.bancox.ui.theme.CustomTheme
import com.yanfalcao.bancox.ui.theme.GovernorBay
import com.yanfalcao.bancox.utils.Format

@Composable
fun TransactionRow(
    title: String,
    subtitle: String,
    transactionValue: Double,
    icon: Painter,
    iconBackgroundColor: Color,
    modifier: Modifier
) {
    val valueColor = if (transactionValue < 0) {
        MaterialTheme.colorScheme.error
    } else {
        MaterialTheme.colorScheme.primary
    }

    Row(
        modifier = modifier,
    ) {
        Box(
            modifier = Modifier
                .requiredSizeIn(minHeight = 40.dp, maxHeight = 80.dp, minWidth = 40.dp, maxWidth = 80.dp,)
                .background(iconBackgroundColor, RoundedCornerShape(size = 10.dp)),
            contentAlignment = Alignment.Center,
        ) {
            Icon(
                painter = icon,
                contentDescription = null,
                tint = Color.White,
                modifier = Modifier
                    .height(16.dp),
            )
        }

        Column(
            modifier = Modifier
                .padding(start = 16.dp)
                .align(Alignment.CenterVertically),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Text(title,
                style = MaterialTheme.typography.bodyLarge.copy(
                    color = MaterialTheme.colorScheme.onBackground,
                ),
            )

            Text(subtitle,
                style = MaterialTheme.typography.labelLarge.copy(
                    color = MaterialTheme.colorScheme.onSurface,
                ),
            )
        }

        Spacer(modifier = Modifier.weight(1.0f))

        Text(
            Format.formatCurrency(transactionValue),
            style = MaterialTheme.typography.titleSmall.copy(
                color = valueColor,
            ),
        )
    }
}

@Preview
@Composable
fun preview() {
    CustomTheme(
        dynamicColor = false,
    ) {
        TransactionRow(
            title = "Conta de água",
            subtitle = "Sem sucesso",
            transactionValue = -280.00,
            icon = painterResource(R.drawable.ic_water_drop),
            iconBackgroundColor = GovernorBay,
            modifier = Modifier
                .fillMaxWidth()
                .background(MaterialTheme.colorScheme.background)
        )
    }
}
