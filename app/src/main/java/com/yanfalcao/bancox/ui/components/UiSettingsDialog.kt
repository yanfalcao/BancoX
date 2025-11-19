package com.yanfalcao.bancox.ui.components

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import com.yanfalcao.bancox.model.ColorThemeOptions
import com.yanfalcao.bancox.ui.theme.CustomTheme

@Composable
fun UiSettingsDialog(
    onDismissRequest: () -> Unit,
    onOptionSelected: (ColorThemeOptions) -> Unit,
) {
    var selectedOption by remember { mutableStateOf(ColorThemeOptions.System.title) }

    Dialog(
        onDismissRequest = { onDismissRequest() }
    ) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .heightIn(min = 100.dp, max = 400.dp),
            shape = RoundedCornerShape(16.dp),
        ) {
            Column(
                modifier = Modifier
                    .padding(horizontal = 16.dp, vertical = 24.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "Configurações",
                    modifier = Modifier
                        .fillMaxWidth()
                        .wrapContentSize(Alignment.Center),
                    textAlign = TextAlign.Center,
                    style = MaterialTheme.typography.titleMedium.copy(
                        color = MaterialTheme.colorScheme.onBackground
                    )
                )

                Spacer(Modifier.height(20.dp))

                ColorThemeOptions.entries.forEach { option ->
                    val isSelected = option.title == selectedOption
                    val radioModifier = if (isSelected) {
                        Modifier.border(
                            width = 2.dp,
                            color = MaterialTheme.colorScheme.primary,
                            shape = RoundedCornerShape(32.dp)
                        )
                    } else {
                        Modifier
                    }

                    Row(
                        radioModifier
                            .fillMaxWidth()
                            .selectable(
                                selected = (option.title == selectedOption),
                                onClick = {
                                    onOptionSelected(option)
                                    selectedOption = option.title
                                },
                                role = Role.RadioButton
                            )
                            .padding(vertical = 8.dp)
                            .padding(horizontal = 16.dp, vertical = 8.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        RadioButton(
                            selected = isSelected,
                            onClick = null
                        )

                        Text(
                            text = option.title,
                            color = MaterialTheme.colorScheme.onBackground,
                            style = MaterialTheme.typography.bodyLarge,
                            modifier = Modifier.padding(start = 16.dp)
                        )
                    }
                }
            }
        }
    }
}

@Preview
@Composable
fun UiSettingsDialogPreview() {
    CustomTheme(
        dynamicColor = false
    ) {
        UiSettingsDialog(
            onDismissRequest = {},
            onOptionSelected = {}
        )
    }
}