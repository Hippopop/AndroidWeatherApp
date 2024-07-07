package com.mostafij.androidweatherapp.data

import android.content.Context
import com.mostafij.androidweatherapp.data.network.CurrentWeatherRepoProvider
import com.mostafij.androidweatherapp.data.network.CurrentWeatherRepository


interface AppContainer {
    val currentWeatherRepository: CurrentWeatherRepository
}

class AppContainerImpl(private val applicationContext: Context) : AppContainer {
    override val currentWeatherRepository: CurrentWeatherRepository by lazy {
        CurrentWeatherRepoProvider.currentWeatherRepository
    }
}