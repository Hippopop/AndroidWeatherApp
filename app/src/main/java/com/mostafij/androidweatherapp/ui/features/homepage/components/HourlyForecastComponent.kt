package com.mostafij.androidweatherapp.ui.features.homepage.components

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.mostafij.androidweatherapp.constants.StringConstants


@OptIn(ExperimentalStdlibApi::class)
@Composable
fun HourlyForecastComponent(modifier: Modifier = Modifier, isDark: Boolean) {
    val bgColor =
        if (isDark) MaterialTheme.colorScheme.inversePrimary else MaterialTheme.colorScheme.tertiary;
    Box(
        modifier = modifier
            .fillMaxSize()
            .padding(5.dp)
            .padding(top = if (isDark) 0.dp else 16.dp, bottom = if (isDark) 16.dp else 0.dp)
            .background(
                color = bgColor,
                shape = RoundedCornerShape(100.dp),
            )
            .border(
                1.dp,
                MaterialTheme.colorScheme.inversePrimary.copy(alpha = 0.7f),
                shape = RoundedCornerShape(100.dp)
            ),
    ) {
        Column(
            modifier = Modifier
                .padding(8.dp)
                .width(64.dp)
        ) {
            Box(
                Modifier
                    .weight(1f)
                    .fillMaxSize()
            ) {
                Text(
                    text = "00${StringConstants.CELSIUS}",
                    color = if (!isDark) Color.White else Color.Black,
                    modifier = Modifier.align(Alignment.Center),
                )
            };
            Box(
                Modifier
                    .weight(1f)
                    .fillMaxSize()
                    .aspectRatio(1f)
                    .padding(4.dp)
                    .background(
                        shape = CircleShape,
                        color = MaterialTheme.colorScheme.secondary.copy(alpha = .30f),
                    )
            ) {
                Text(
                    text = "N/A",
                    color = MaterialTheme.colorScheme.primaryContainer,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier
                        .align(Alignment.Center)
                        .padding(4.dp),
                )
            };
            Box(
                Modifier
                    .weight(1f)
                    .fillMaxSize()
            ) {
                Text(
                    text = "1 AM",
                    color = if (!isDark) Color.White else Color.Black,
                    modifier = Modifier.align(Alignment.Center),
                )
            };
        }
    }
}