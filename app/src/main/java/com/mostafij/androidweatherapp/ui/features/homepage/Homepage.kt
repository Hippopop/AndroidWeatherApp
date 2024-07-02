package com.mostafij.androidweatherapp.ui.features.homepage

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Menu
import androidx.compose.material.icons.rounded.Refresh
import androidx.compose.material3.CenterAlignedTopAppBar
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.mostafij.androidweatherapp.ui.components.DrawerSection
import com.mostafij.androidweatherapp.ui.features.homepage.components.CurrentWeatherComponent
import com.mostafij.androidweatherapp.ui.features.homepage.components.WeatherForecastComponent
import com.mostafij.androidweatherapp.ui.viewmodel.WeatherDataViewModel
import kotlinx.coroutines.launch


@Preview
@Composable
fun HomepagePrev() {
    val viewModel: WeatherDataViewModel = viewModel()
    Homepage(viewModel = viewModel)
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Homepage(modifier: Modifier = Modifier, viewModel: WeatherDataViewModel) {
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
                        imageVector = Icons.Rounded.Refresh,
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
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues),
            ) {
                CurrentWeatherComponent(Modifier.weight(4f))
                WeatherForecastComponent(Modifier.weight(6f))
            }
        }
    }
}





