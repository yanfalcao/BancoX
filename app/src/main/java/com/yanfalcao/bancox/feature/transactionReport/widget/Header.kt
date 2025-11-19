package com.yanfalcao.bancox.feature.transactionReport.widget

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredSizeIn
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowLeft
import androidx.compose.material.icons.filled.Settings
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
    modifier: Modifier = Modifier,
    onClickSettings: () -> Unit = {}
) {
    Row(modifier) {
        Icon(
            imageVector = Icons.AutoMirrored.Filled.KeyboardArrowLeft,
            contentDescription = null,
            tint = Color.White,
            modifier = Modifier.size(40.dp),
        )
        Text(
            text = title,
            color = MaterialTheme.colorScheme.onPrimary,
            style = MaterialTheme.typography.titleLarge,
            modifier = Modifier.padding(start = 8.dp).align(Alignment.CenterVertically)
        )

        Spacer(modifier = Modifier.weight(1.0f))

        Box(
            modifier = Modifier
                .requiredSizeIn(minHeight = 40.dp, maxHeight = 80.dp, minWidth = 40.dp, maxWidth = 80.dp,)
                .background(MaterialTheme.colorScheme.background, CircleShape)
                .clickable(enabled = true, onClick = onClickSettings),
            contentAlignment = Alignment.Center,
        ) {
            Icon(
                imageVector = Icons.Filled.Settings,
                contentDescription = null,
                tint = MaterialTheme.colorScheme.onBackground,
                modifier = Modifier.padding(8.dp),
            )
        }
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