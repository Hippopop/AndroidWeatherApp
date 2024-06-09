package com.mostafij.androidweatherapp.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.runtime.Composable

private val DarkColorScheme = darkColorScheme(
    primary = _primaryColor,
    secondary = _backgroundColor,
    tertiary = _primaryAccent,
    background = _primaryColor,
)

@Composable
fun AndroidWeatherAppTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    dynamicColor: Boolean = true,
    content: @Composable () -> Unit
) {

    // -> Enables the Dynamic color scheme system.
    //    val colorScheme = when {
    //        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
    //            val context = LocalContext.current
    //            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
    //        }
    //
    //        else -> DarkColorScheme
    //    }

    MaterialTheme(
        colorScheme = DarkColorScheme,
        typography = Typography,
        content = content
    )
}