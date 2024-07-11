package com.mostafij.androidweatherapp.data

import android.content.Context
import com.mostafij.androidweatherapp.data.repository.current.impl.CurrentWeatherRepoProvider


interface AppContainer {
    val currentWeatherRepository: CurrentWeatherRepoProvider
}

class AppContainerImpl(private val applicationContext: Context) : AppContainer {
    override val currentWeatherRepository: CurrentWeatherRepoProvider by lazy {
        CurrentWeatherRepoProvider()
    }
}