package com.yanfalcao.bancox.feature.transactionReport.widget

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.yanfalcao.bancox.ui.theme.CustomTheme

@Composable
fun BackgroundReport(
    modifier: Modifier = Modifier,
    content: @Composable BoxScope.() -> Unit
) {
    Box(modifier
        .fillMaxSize()
        .background(MaterialTheme.colorScheme.primary)
    ) {
        Box(
            Modifier
                .fillMaxWidth()
                .fillMaxHeight(fraction = 0.8f)
                .background(
                    MaterialTheme.colorScheme.background,
                    RoundedCornerShape(topStart = 40.dp, topEnd = 40.dp)
                )
                .align(alignment = Alignment.BottomCenter),
        )

        content()
    }
}

@Preview
@Composable
fun BackgroundReportPreview() {
    CustomTheme(
        dynamicColor = false,
    ) {
        BackgroundReport {

        }
    }
}