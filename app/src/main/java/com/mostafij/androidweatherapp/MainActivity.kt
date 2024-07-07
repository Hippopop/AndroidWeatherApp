package com.mostafij.androidweatherapp

import android.app.Application
import android.graphics.Color
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.SystemBarStyle
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.mostafij.androidweatherapp.data.AppContainer
import com.mostafij.androidweatherapp.data.AppContainerImpl


class MyApplication : Application() {
    lateinit var container: AppContainer

    override fun onCreate() {
        super.onCreate()
        container = AppContainerImpl(this)
    }
}


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        enableEdgeToEdge(
            statusBarStyle = SystemBarStyle.auto(
                Color.parseColor("#801b1b1b"),
                Color.parseColor("#801b1b1b"),
            ),
        );
        super.onCreate(savedInstanceState)

        val appContainer: AppContainer = (application as MyApplication).container;
        setContent { AndroidWeatherApp(appContainer) }
    }
}



