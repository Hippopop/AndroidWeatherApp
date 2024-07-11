package com.mostafij.androidweatherapp.data.repository.current.impl

import com.mostafij.androidweatherapp.data.model.CurrentWeatherResponse
import com.mostafij.androidweatherapp.data.network.CurrentWeatherDomain
import com.mostafij.androidweatherapp.data.network.RetrofitProvider
import com.mostafij.androidweatherapp.data.repository.current.CurrentWeatherRepo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class CurrentWeatherRepoProvider : CurrentWeatherRepo {
    private val currentWeatherDomain =
        RetrofitProvider.getRetrofit().create(CurrentWeatherDomain::class.java);

    override suspend fun getCurrentWeatherData(locationString: String): Result<CurrentWeatherResponse> {
        return withContext(Dispatchers.IO) {
            val currentWeatherResponse = currentWeatherDomain.getCurrentWeather(locationString);
            if (currentWeatherResponse.isSuccessful) {
                Result.success(currentWeatherResponse.body()!!);
            } else {
                Result.failure(Exception(currentWeatherResponse.errorBody()?.string()))
            }
        }
    }
}

