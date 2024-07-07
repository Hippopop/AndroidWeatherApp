package com.mostafij.androidweatherapp

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.compose.rememberNavController
import com.mostafij.androidweatherapp.data.AppContainer
import com.mostafij.androidweatherapp.system.navigation.AppNavigationController
import com.mostafij.androidweatherapp.system.navigation.AppNavigationGraph
import com.mostafij.androidweatherapp.ui.theme.AndroidWeatherAppTheme

@Composable
fun AndroidWeatherApp(appContainer: AppContainer) {
    val navController = rememberNavController();
    val appNavigationController = remember {
        AppNavigationController(navController);
    }

    AndroidWeatherAppTheme {
        AppNavigationGraph(
            appContainer = appContainer,
            navController = navController,
            appNavigationController = appNavigationController,
        );
    };
}