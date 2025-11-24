package com.yanfalcao.bancox.ui.theme

import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import com.yanfalcao.bancox.model.ColorThemeOptions

private val DarkColorScheme = darkColorScheme(
    primary = BlueViolet,
    onPrimary = White,
    secondary = Grape,
    onSecondary = White,
    tertiary = CornflowerBlue,
    onTertiary = White,
    background = MineShaft,
    onBackground = White,
    error = RadicalRed,
    onSurface = DustyGray,
    outline = Gallery
)

private val LightColorScheme = lightColorScheme(
    primary = GovernorBay,
    onPrimary = White,
    secondary = Grape,
    onSecondary = White,
    tertiary = CornflowerBlue,
    onTertiary = White,
    background = White,
    onBackground = MineShaft,
    error = RadicalRed,
    onSurface = DustyGray,
    outline = Gallery
)

@Composable
fun CustomTheme(
    themeOptions: ColorThemeOptions,
    content: @Composable () -> Unit
) {
    val colorScheme = when(themeOptions) {
        ColorThemeOptions.Light -> LightColorScheme
        ColorThemeOptions.Dark -> DarkColorScheme
        ColorThemeOptions.System -> {
            if (isSystemInDarkTheme()) DarkColorScheme else LightColorScheme
        }
        ColorThemeOptions.Dynamic -> {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
                val context = LocalContext.current
                if (isSystemInDarkTheme()) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
            } else {
                if (isSystemInDarkTheme()) DarkColorScheme else LightColorScheme

            }
        }
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}