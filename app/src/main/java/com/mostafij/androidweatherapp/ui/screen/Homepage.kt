package com.mostafij.androidweatherapp.ui.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.mostafij.androidweatherapp.ui.viewmodel.WeatherDataViewModel

@Composable
fun Homepage(modifier: Modifier = Modifier, viewModel: WeatherDataViewModel) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier.fillMaxWidth(),
    ) {
        Text(text = "Hello Android!", modifier = modifier)
        Box(modifier = modifier.padding(vertical = 12.dp)) {
            TextButton(
                onClick = { viewModel.getWeatherData("London") },
                modifier = modifier.background(color = Color.Magenta),
            ) {
                Text(text = "Hello Android!", modifier = modifier)
            }
        }
    }
}