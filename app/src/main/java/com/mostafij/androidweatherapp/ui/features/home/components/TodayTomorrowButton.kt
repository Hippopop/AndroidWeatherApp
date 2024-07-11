package com.mostafij.androidweatherapp.ui.features.home.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.mostafij.androidweatherapp.ui.features.home.viewmodel.ForecastDay


@Composable
fun TodayTomorrowButton(
    modifier: Modifier = Modifier,
    selected: ForecastDay,
    forecastDay: ForecastDay,
    onSelect: (it: ForecastDay) -> Unit,
) {
    Column(horizontalAlignment = Alignment.CenterHorizontally, modifier = modifier) {
        Text(
            text = forecastDay.name.lowercase().replaceFirstChar { it.uppercase() },
            style = MaterialTheme.typography.titleLarge,
            modifier = Modifier
                .padding(horizontal = 8.dp, vertical = 4.dp)
                .clickable { onSelect(forecastDay) },
        );
        if (selected == forecastDay) {
            Box(
                modifier = Modifier
                    .size(5.dp)
                    .background(
                        shape = CircleShape,
                        color = Color.White,
                    ),
            )
        }
    }
}