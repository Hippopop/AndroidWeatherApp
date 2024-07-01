package com.mostafij.androidweatherapp.ui.components

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.isUnspecified
import androidx.compose.ui.unit.sp


@Composable
fun AutoResizedText(
    modifier: Modifier = Modifier,
    text: String,
    style: TextStyle = MaterialTheme.typography.bodyMedium,
    color: Color = style.color
) {
    val defaultFontSize = 900.sp;
    var resizedTextStyle by remember {
        mutableStateOf(style)
    }
    var shouldDraw by remember {
        mutableStateOf(false)
    }

    Text(text = text, color = color, modifier = modifier.drawWithContent {
        if (shouldDraw) {
            drawContent()
        }
    }, softWrap = false, style = resizedTextStyle, onTextLayout = { result ->
        if (result.didOverflowWidth || result.didOverflowHeight) {
            if (style.fontSize.isUnspecified) {
                resizedTextStyle = resizedTextStyle.copy(
                    fontSize = defaultFontSize
                )
            }
            resizedTextStyle = resizedTextStyle.copy(
                fontSize = resizedTextStyle.fontSize * 0.95
            )
        } else {
            shouldDraw = true
        }
    })
}