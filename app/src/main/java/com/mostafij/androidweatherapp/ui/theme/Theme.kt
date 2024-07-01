package com.mostafij.androidweatherapp.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val DarkColorScheme = darkColorScheme(
    primary = primaryColor,
    tertiary = primaryAccent,
    background = primaryColor,
    secondary = backgroundColor,
    inversePrimary = textColor,
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