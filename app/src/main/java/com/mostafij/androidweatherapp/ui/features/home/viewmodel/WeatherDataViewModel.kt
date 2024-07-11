package com.mostafij.androidweatherapp.ui.features.home.viewmodel

import android.util.Log
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.mostafij.androidweatherapp.data.model.CurrentWeatherData
import com.mostafij.androidweatherapp.data.model.LocationData
import com.mostafij.androidweatherapp.data.repository.current.impl.CurrentWeatherRepoProvider
import com.mostafij.androidweatherapp.utils.BaseError
import com.mostafij.androidweatherapp.utils.BaseState
import kotlinx.coroutines.launch

enum class ForecastDay {
    TODAY, TOMORROW
}

sealed interface HomePageState {
    val errorList: List<BaseError>;
    val currentState: BaseState;
    val selectedDay: ForecastDay;

    data class Success(
        val locationData: LocationData,
        val currentWeatherData: CurrentWeatherData,
        override val selectedDay: ForecastDay = ForecastDay.TODAY,
        override val currentState: BaseState = BaseState.SUCCESS,
        override val errorList: List<BaseError> = emptyList(),
    ) : HomePageState;

    data class Error(
        override val errorList: List<BaseError>,
        override val currentState: BaseState = BaseState.ERROR,
        override val selectedDay: ForecastDay = ForecastDay.TODAY,
    ) : HomePageState;

    data class Loading(
        override val currentState: BaseState = BaseState.LOADING,
        override val selectedDay: ForecastDay = ForecastDay.TODAY,
        override val errorList: List<BaseError> = emptyList(),
    ) : HomePageState;
}

private data class WeatherDataViewModelState(
    val errorList: List<BaseError> = emptyList(),
    val currentState: BaseState = BaseState.LOADING,
    val selectedDay: ForecastDay = ForecastDay.TODAY,
    val locationData: LocationData? = null,
    val currentWeatherData: CurrentWeatherData? = null,
) {
    fun toHomepageState(): HomePageState = when (currentState) {
        BaseState.LOADING -> HomePageState.Loading(selectedDay = selectedDay);
        BaseState.ERROR -> HomePageState.Error(errorList = errorList, selectedDay = selectedDay);
        BaseState.SUCCESS -> HomePageState.Success(
            selectedDay = selectedDay,
            locationData = locationData!!,
            currentWeatherData = currentWeatherData!!,
        );
    }

}

class WeatherDataViewModel(private val currentWeatherRepository: CurrentWeatherRepoProvider) :
    ViewModel() {
    private val currentVMState = mutableStateOf(WeatherDataViewModelState());
    val homePageState by derivedStateOf {
        currentVMState.value.toHomepageState();
    };

    init {
        getWeatherData("Mumbai");
    }

    fun onSelectedDayChange(forecastDay: ForecastDay) {
        currentVMState.value = currentVMState.value.copy(selectedDay = forecastDay);
        Log.d("WeatherDataViewModel", "onSelectedDayChange: $forecastDay");
    }

    private fun getWeatherData(city: String) {
        try {
            viewModelScope.launch {
                val response = currentWeatherRepository.getCurrentWeatherData(city);
                if (response.isSuccess) {
                    val data = response.getOrThrow();
                    currentVMState.value = currentVMState.value.copy(
                        currentState = BaseState.SUCCESS,
                        locationData = data.locationData!!,
                        currentWeatherData = data.currentWeatherData!!,
                    );

                    Log.d("WeatherDataViewModel", "_homePageState: $currentVMState");
                } else {
                    currentVMState.value = currentVMState.value.copy(
                        currentState = BaseState.ERROR, errorList = listOf(
                            BaseError(
                                code = 400,
                                msg = response.exceptionOrNull()?.message
                                    ?: "Something went wrong, please try again!",
                            )
                        )
                    );
                }
            }
        } catch (e: Exception) {
            currentVMState.value = currentVMState.value.copy(
                currentState = BaseState.ERROR, errorList = listOf(
                    BaseError(
                        code = 500, msg = e.message ?: "Something went wrong, please try again!"
                    )
                )
            );

        }
    };

    /*private val currentVMState = MutableStateFlow(WeatherDataViewModelState());
    val homePageState: StateFlow<HomePageState> =
        currentVMState.map { it.toHomepageState() }.stateIn(
            viewModelScope,
            SharingStarted.Eagerly,
            currentVMState.value.toHomepageState(),
        );

    init {
        getWeatherData("Mumbai");
    }

    fun onSelectedDayChange(forecastDay: ForecastDay) {
        currentVMState.update { it.copy(selectedDay = forecastDay) };
        Log.d("WeatherDataViewModel", "onSelectedDayChange: $forecastDay");
    }

    private fun getWeatherData(city: String) {
        try {
            viewModelScope.launch {
                val response = currentWeatherRepository.getCurrentWeatherData(city);
                if (response.isSuccess) {
                    val data = response.getOrThrow();
                    currentVMState.update {
                        it.copy(
                            currentState = BaseState.SUCCESS,
                            locationData = data.locationData!!,
                            currentWeatherData = data.currentWeatherData!!,
                        )
                    };

                    Log.d("WeatherDataViewModel", "_homePageState: $currentVMState");
                } else {
                    currentVMState.update {
                        it.copy(
                            currentState = BaseState.ERROR, errorList = listOf(
                                BaseError(
                                    code = 400,
                                    msg = response.exceptionOrNull()?.message
                                        ?: "Something went wrong, please try again!",
                                )
                            )
                        )
                    }
                }
            }
        } catch (e: Exception) {
            currentVMState.update {
                it.copy(
                    currentState = BaseState.ERROR, errorList = listOf(
                        BaseError(
                            code = 500, msg = e.message ?: "Something went wrong, please try again!"
                        )
                    )
                )
            };

        }
    };*/

    companion object {
        fun provideFactory(
            currentWeatherRepository: CurrentWeatherRepoProvider,
        ): ViewModelProvider.Factory = object : ViewModelProvider.Factory {
            override fun <T : ViewModel> create(modelClass: Class<T>): T {
                @Suppress("UNCHECKED_CAST") return WeatherDataViewModel(currentWeatherRepository) as T;
            }
        }
    }
}