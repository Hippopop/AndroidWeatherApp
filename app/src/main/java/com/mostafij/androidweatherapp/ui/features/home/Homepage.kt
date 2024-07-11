package com.mostafij.androidweatherapp.ui.features.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.LocationOn
import androidx.compose.material.icons.rounded.Menu
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.mostafij.androidweatherapp.ui.components.DrawerSection
import com.mostafij.androidweatherapp.ui.features.home.components.CurrentWeatherComponent
import com.mostafij.androidweatherapp.ui.features.home.components.WeatherForecastComponent
import com.mostafij.androidweatherapp.ui.features.home.viewmodel.ForecastDay
import com.mostafij.androidweatherapp.ui.features.home.viewmodel.HomePageState
import com.mostafij.androidweatherapp.ui.theme.AndroidWeatherAppTheme
import com.mostafij.androidweatherapp.utils.BaseError
import kotlinx.coroutines.launch


@Preview
@Composable
fun HomepagePreview() {
    AndroidWeatherAppTheme {
        Homepage(
            goToForecastScreen = {}, onDayChange = {},
            homePageState = HomePageState.Error(
                errorList = listOf(BaseError.unknownBaseError)
            ),
        );
    };
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Homepage(
    modifier: Modifier = Modifier,
    homePageState: HomePageState,
    goToForecastScreen: () -> Unit,
    onDayChange: (ForecastDay) -> Unit,
) {
    val coroutineScope = rememberCoroutineScope()
    val drawerState = rememberDrawerState(DrawerValue.Closed)

    ModalNavigationDrawer(drawerState = drawerState, drawerContent = {
        DrawerSection()
    }) {
        Scaffold(topBar = {
            CenterAlignedTopAppBar(colors = TopAppBarDefaults.topAppBarColors(
                containerColor = MaterialTheme.colorScheme.primary
            ), navigationIcon = {
                IconButton(onClick = {
                    coroutineScope.launch {
                        if (drawerState.isOpen) {
                            drawerState.close()
                        } else {
                            drawerState.open()
                        }
                    }
                }) {
                    Icon(
                        tint = Color.White,
                        imageVector = Icons.Rounded.Menu,
                        contentDescription = "Search Button",
                    )
                }
            }, actions = {
                IconButton(onClick = { /*TODO*/ }) {
                    Icon(
                        tint = Color.White,
                        imageVector = Icons.Rounded.LocationOn,
                        contentDescription = "Search Button",
                    )
                }
            }, title = {
                Text(
                    text = "Android Weather App",
                    color = Color.White,
                )
            })
        }) { paddingValues ->
            when (homePageState) {
                is HomePageState.Error -> Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center,
                    modifier = Modifier.fillMaxSize()
                ) {
                    homePageState.errorList.forEach {
                        Row(modifier = Modifier.padding(horizontal = 16.dp)) {
                            Text(
                                buildAnnotatedString {
                                    withStyle(style = SpanStyle(color = MaterialTheme.colorScheme.error)) {
                                        append("Error code:${it.code}  ")
                                    };
                                    withStyle(style = SpanStyle(color = MaterialTheme.colorScheme.inversePrimary)) {
                                        append(it.msg);
                                    };
                                },
                                textAlign = TextAlign.Center,
                            );
                        };
                    }
                };
                is HomePageState.Loading -> Box(modifier = Modifier.fillMaxSize()) {
                    CircularProgressIndicator(
                        color = MaterialTheme.colorScheme.primaryContainer,
                        trackColor = MaterialTheme.colorScheme.inversePrimary,
                        modifier = Modifier
                            .width(64.dp)
                            .align(Alignment.Center),
                    );
                };

                is HomePageState.Success -> Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(paddingValues),
                ) {
                    CurrentWeatherComponent(
                        currentWeatherData = homePageState.currentWeatherData,
                        locationData = homePageState.locationData,
                        modifier = Modifier.weight(4f),
                    )
                    WeatherForecastComponent(
                        onDayChange = onDayChange,
                        currentDay = homePageState.selectedDay,
                        navigateToForecastDay = goToForecastScreen,
                        modifier = Modifier.weight(6f),
                    )
                }
            }
        }
    }
}





