package com.mostafij.androidweatherapp.data.repository.current

import com.mostafij.androidweatherapp.data.model.CurrentWeatherResponse

interface CurrentWeatherRepo {
    suspend fun getCurrentWeatherData(locationString: String): Result<CurrentWeatherResponse>
}