package com.mostafij.androidweatherapp.ui.features.forecast

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.mostafij.androidweatherapp.system.navigation.AppNavigationController

@Composable
fun WeeklyForecastPage(modifier: Modifier = Modifier, appNavigationController: AppNavigationController) {
    Scaffold {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = modifier
                .padding(it)
                .fillMaxSize()
        ) {
            Text(text = "Weekly Forecast Screen!");
            IconButton(onClick = { appNavigationController.back() }) {
                Icon(
                    tint = Color.White,
                    contentDescription = "Back Button",
                    imageVector = Icons.AutoMirrored.Default.ArrowBack,
                )
            }
        }
    }
}
