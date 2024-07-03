package com.mostafij.androidweatherapp.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

// Set of Material typography styles to start with
val Typography = Typography(
    bodyLarge = TextStyle(
        fontSize = 14.sp,
        lineHeight = 24.sp,
        color = mildTextColor,
        letterSpacing = 0.5.sp,
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
    ),
   titleLarge =  TextStyle(
        fontSize = 16.sp,
        lineHeight = 24.sp,
        color = textColor,
        letterSpacing = 0.5.sp,
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
    )
)