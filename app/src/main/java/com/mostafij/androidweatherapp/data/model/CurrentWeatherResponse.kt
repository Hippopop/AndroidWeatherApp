package com.mostafij.androidweatherapp.data.model

import com.google.gson.annotations.SerializedName

data class CurrentWeatherResponse(
    @SerializedName("location") val locationData: LocationData?,
    @SerializedName("current") val currentWeatherData: CurrentWeatherData?,
)


