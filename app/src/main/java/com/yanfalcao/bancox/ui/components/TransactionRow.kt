package com.yanfalcao.bancox.ui.components

import android.graphics.drawable.Icon
import androidx.compose.foundation.layout.Row
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun TransactionRow(
    title: String,
    subtitle: String,
    icon: ImageVector,
    iconBackgroundColor: Color,
) {
    Row {

    }
}

@Preview
@Composable
fun preview() {
    TransactionRow()
}
