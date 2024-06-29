package com.mostafij.androidweatherapp.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.runtime.Composable

private val DarkColorScheme = darkColorScheme(
    primary = _primaryColor,
    tertiary = _primaryAccent,
    background = _primaryColor,
    secondary = _backgroundColor,
)

@Composable
fun AndroidWeatherAppTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    dynamicColor: Boolean = true,
    content: @Composable () -> Unit
) {
    MaterialTheme(
        content = content,
        typography = Typography,
        colorScheme = DarkColorScheme,
    )
}