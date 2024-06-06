package com.mostafij.androidweatherapp.ui.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mostafij.androidweatherapp.data.network.CurrentWeatherRepoProvider
import com.mostafij.androidweatherapp.data.network.CurrentWeatherRepository
import kotlinx.coroutines.launch
import retrofit2.HttpException

class WeatherDataViewModel : ViewModel() {
    val weatherRepo: CurrentWeatherRepository = CurrentWeatherRepoProvider.currentWeatherRepository;

    fun getWeatherData(city: String) {
        viewModelScope.launch {
//                val response = weatherRepo.getCurrentWeather(city);
//                if (response.isSuccessful) {
//                    println(response.body());
//                } else {
//                    Log.e("POSITION - 1", response.errorBody()?.string() ?: "Response Error Is Empty!");
//                }

        }
    };
}