package com.mostafij.androidweatherapp.data.network

object CurrentWeatherRepoProvider {
    val currentWeatherRepository =
        RetrofitProvider.getRetrofit().create(CurrentWeatherRepository::class.java);
}