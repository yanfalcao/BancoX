package com.yanfalcao.bancox.model

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

enum class TransactionTypeEnum {
    SALARY, FOOD, ENTERTAINMENT, BILL
}

@Composable
fun TransactionTypeEnum.getColorIcon(): Color {
    return when (this) {
        TransactionTypeEnum.SALARY -> MaterialTheme.colorScheme.onPrimary
        TransactionTypeEnum.FOOD -> MaterialTheme.colorScheme.onSecondary
        TransactionTypeEnum.ENTERTAINMENT -> MaterialTheme.colorScheme.onTertiary
        TransactionTypeEnum.BILL -> MaterialTheme.colorScheme.onSecondary
    }
}

@Composable
fun TransactionTypeEnum.getColorIconBackground(): Color {
    return when (this) {
        TransactionTypeEnum.SALARY -> MaterialTheme.colorScheme.primary
        TransactionTypeEnum.FOOD -> MaterialTheme.colorScheme.secondary
        TransactionTypeEnum.ENTERTAINMENT -> MaterialTheme.colorScheme.tertiary
        TransactionTypeEnum.BILL -> MaterialTheme.colorScheme.secondary
    }
}