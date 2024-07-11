package com.mostafij.androidweatherapp.system.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.mostafij.androidweatherapp.data.AppContainer
import com.mostafij.androidweatherapp.ui.features.forecast.WeeklyForecastPage
import com.mostafij.androidweatherapp.ui.features.home.Homepage
import com.mostafij.androidweatherapp.ui.features.home.viewmodel.WeatherDataViewModel

@Composable
fun AppNavigationGraph(
    appContainer: AppContainer,
    modifier: Modifier = Modifier,
    appNavigationController: AppNavigationController,
    navController: NavHostController = rememberNavController(),
    startDestination: String = ApplicationDestinations.HOME_ROUTE,
) {
    NavHost(navController = navController, startDestination = startDestination) {
        composable(ApplicationDestinations.HOME_ROUTE) {
            val weatherDataViewModel: WeatherDataViewModel =
                viewModel(factory = WeatherDataViewModel.provideFactory(appContainer.currentWeatherRepository));
//            val stateFlow =  weatherDataViewModel.homePageState.collectAsStateWithLifecycle();
            Homepage(
                homePageState = weatherDataViewModel.homePageState,
                onDayChange = { weatherDataViewModel.onSelectedDayChange(it) },
                goToForecastScreen = appNavigationController.navigateToWeeklyForecast,
            );
        }
        composable(ApplicationDestinations.FORECAST_ROUTE) {
            WeeklyForecastPage(appNavigationController = appNavigationController);
        }
    }
}