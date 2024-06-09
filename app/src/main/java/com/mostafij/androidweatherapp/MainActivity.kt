package com.mostafij.androidweatherapp

import android.graphics.Color
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.SystemBarStyle
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
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
        enableEdgeToEdge(
            statusBarStyle = SystemBarStyle.auto(
                Color.parseColor("#801b1b1b"),
                Color.parseColor("#801b1b1b"),
            ),
        )
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

