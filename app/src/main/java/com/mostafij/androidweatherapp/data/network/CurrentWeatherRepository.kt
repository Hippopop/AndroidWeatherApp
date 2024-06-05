package com.mostafij.androidweatherapp.data.network

import com.mostafij.androidweatherapp.constants.AppConstants
import com.mostafij.androidweatherapp.data.model.CurrentWeatherResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface CurrentWeatherRepository {
    @GET("v1/current.json")
    suspend fun getCurrentWeather(
        @Query("q") location: String,
        @Query("aqi") airQuality: String = "no",
        @Query("key") apiKey: String = AppConstants.API_KEY,
    ): Response<CurrentWeatherResponse>;
}