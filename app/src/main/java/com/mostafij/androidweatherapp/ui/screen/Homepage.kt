package com.mostafij.androidweatherapp.ui.screen

import android.util.Log
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Menu
import androidx.compose.material.icons.rounded.Refresh
import androidx.compose.material.icons.rounded.ShoppingCart
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mostafij.androidweatherapp.ui.viewmodel.WeatherDataViewModel
import kotlinx.coroutines.launch

@Composable
fun DrawerSection(modifier: Modifier = Modifier) {
    ModalDrawerSheet {
        Box(
            modifier
                .fillMaxWidth()
                .height(300.dp)
                .background(color = MaterialTheme.colorScheme.background)
        ) {
            Text(
                "Drawer title", modifier = Modifier.padding(16.dp)
            )
        }
        HorizontalDivider()
        NavigationDrawerItem(label = { Text(text = "Drawer Item") },
            selected = false,
            onClick = { /*TODO*/ })
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Homepage(modifier: Modifier = Modifier, viewModel: WeatherDataViewModel) {

    val coroutineScope = rememberCoroutineScope()
    val drawerState = rememberDrawerState(DrawerValue.Closed)
    ModalNavigationDrawer(drawerState = drawerState, drawerContent = {
        DrawerSection(modifier = modifier)
    }) {
        Scaffold(topBar = {
            CenterAlignedTopAppBar(colors = TopAppBarDefaults.topAppBarColors(
                containerColor = MaterialTheme.colorScheme.primary
            ), navigationIcon = {
                IconButton(onClick = {
                    Log.i("DrawerButton", "Hey! I'm being clicked!")
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
                modifier = modifier
                    .fillMaxWidth()
                    .padding(paddingValues),
            ) {

                Box(
                    modifier = modifier
                        .fillMaxWidth()
                        .background(color = MaterialTheme.colorScheme.primary)
                        .safeDrawingPadding(),
                ) {
                    Row(
                        horizontalArrangement = Arrangement.Start,
                        modifier = modifier.padding(vertical = 0.dp, horizontal = 16.dp),
                    ) {
                        Text(
                            text = "Android Weather App",
                            color = Color.White,
                            fontWeight = FontWeight.Bold,
                            fontSize = 24.sp,
                        )
                    }
                }
                Column(
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = modifier.fillMaxWidth(),
                ) {
                    Text(text = "Hello Android!", modifier = modifier)
                    Row(modifier = modifier.padding(vertical = 12.dp)) {
                        TextButton(
                            shape = RoundedCornerShape(8.dp),
                            border = BorderStroke(1.dp, Color.Black),
                            colors = ButtonDefaults.textButtonColors(
                                containerColor = Color.Magenta,
                                contentColor = Color.White,
                            ),
                            modifier = modifier.clip(RoundedCornerShape(8.dp)),
                            onClick = { viewModel.getWeatherData("London") },
                        ) {
                            Text(text = "Refresh!", modifier = modifier)
                        }
                        IconButton(onClick = { /*TODO*/ }) {
                            Icon(
                                contentDescription = "Search Button",
                                imageVector = Icons.Rounded.ShoppingCart,
                            )
                        }
                    }
                }
            }
        }
    }
}