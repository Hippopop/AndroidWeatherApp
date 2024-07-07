package com.mostafij.androidweatherapp.ui.features.home.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.mostafij.androidweatherapp.data.network.CurrentWeatherRepoProvider
import com.mostafij.androidweatherapp.data.network.CurrentWeatherRepository
import kotlinx.coroutines.launch

class WeatherDataViewModel(private val currentWeatherRepository: CurrentWeatherRepository) :
    ViewModel() {
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

    companion object {
        fun provideFactory(
            currentWeatherRepository: CurrentWeatherRepository,
        ): ViewModelProvider.Factory = object : ViewModelProvider.Factory {
            override fun <T : ViewModel> create(modelClass: Class<T>): T {
                @Suppress("UNCHECKED_CAST")
                return WeatherDataViewModel(currentWeatherRepository) as T;
            }
        }
    }
}