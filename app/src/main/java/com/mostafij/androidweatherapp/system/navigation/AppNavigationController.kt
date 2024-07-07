package com.mostafij.androidweatherapp.system.navigation

import androidx.navigation.NavHostController

object ApplicationDestinations {
    const val HOME_ROUTE = "home"
    const val FORECAST_ROUTE = "forecast"
}

class AppNavigationController(navController: NavHostController) {
    val back: () -> Unit = {
        navController.popBackStack();
    }

    val navigateToHome: () -> Unit = {
        navController.navigate(ApplicationDestinations.HOME_ROUTE) {}
    }
    val navigateToWeeklyForecast: () -> Unit = {
        navController.navigate(ApplicationDestinations.FORECAST_ROUTE){
            ;
        };
    }
}