package com.yanfalcao.bancox.feature.transactionReport.widget

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.yanfalcao.bancox.ui.theme.CustomTheme

@Composable
fun Header(
    title: String,
    modifier: Modifier = Modifier
) {
    Row {
        Icon(
            imageVector = Icons.Filled.KeyboardArrowLeft,
            contentDescription = null,
            tint = Color.White,
            modifier = modifier.size(40.dp),
        )
        Text(
            text = title,
            color = MaterialTheme.colorScheme.onPrimary,
            style = MaterialTheme.typography.titleLarge,
            modifier = Modifier.padding(start = 8.dp).align(Alignment.CenterVertically)
        )
    }
}

@Preview
@Composable
fun HeaderPreview() {
    CustomTheme(
        dynamicColor = false,
    ) {
        Header("Transações")
    }
}