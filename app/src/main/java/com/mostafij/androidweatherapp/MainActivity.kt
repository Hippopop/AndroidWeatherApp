package com.mostafij.androidweatherapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.lifecycle.ViewModelProvider
import com.mostafij.androidweatherapp.ui.screen.Homepage
import com.mostafij.androidweatherapp.ui.theme.AndroidWeatherAppTheme
import com.mostafij.androidweatherapp.ui.viewmodel.WeatherDataViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val viewModel: WeatherDataViewModel =
            ViewModelProvider(this)[WeatherDataViewModel::class.java]
        setContent {
            AndroidWeatherAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background
                ) { Homepage(viewModel = viewModel) }
            }
        }
    }
}

