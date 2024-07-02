package com.mostafij.androidweatherapp.ui.features.homepage.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.mostafij.androidweatherapp.R
import com.mostafij.androidweatherapp.constants.StringConstants


@Composable
fun WeatherForecastComponent(modifier: Modifier = Modifier) {
    val selectedForecastDay = remember { mutableStateOf(ForecastDay.TODAY) };

    Box(
        modifier
            .fillMaxSize()
            .background(color = MaterialTheme.colorScheme.background),
    ) {
        Column {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceAround,
                modifier = Modifier
                    .padding(horizontal = 24.dp)
                    .fillMaxWidth(),
            ) {
                TodayTomorrowButton(
                    selected = selectedForecastDay.value,
                    forecastDay = ForecastDay.TODAY,
                    onSelect = {
                        selectedForecastDay.value = it
                    },
                );
                TodayTomorrowButton(
                    selected = selectedForecastDay.value,
                    forecastDay = ForecastDay.TOMORROW,
                    onSelect = {
                        selectedForecastDay.value = it
                    },
                );
                Row(verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.clickable { }) {
                    Text(text = "Next 7 days", color = Color.Blue);
                    Icon(
                        painter = painterResource(id = R.drawable.arrowhead_right),
                        contentDescription = "Search Button",
                        tint = Color.Blue,
                        modifier = Modifier
                            .size(20.dp)
                            .padding(start = 3.dp)
                    );

                }
            }
            LazyRow(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxHeight()
                    .padding(top= 8.dp)
                    .padding(vertical = 10.dp),
            ) {
                items(10) {
                    HourlyForecastComponent(isDark = (it.mod(2) == 0))
                }
            }
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .weight(1f)
                    .fillMaxSize()
                    .padding(horizontal = 24.dp),
            ) {
                Text(
                    text = "Weather Forecast Section",
                    color = MaterialTheme.colorScheme.inversePrimary,
                )
            }
        }
    }
}

@Composable
fun HourlyForecastComponent(modifier: Modifier = Modifier, isDark: Boolean) {
    Box(
        modifier = modifier
            .fillMaxSize()
            .padding(4.dp)
            .padding(top = if (isDark) 0.dp else 16.dp, bottom = if (isDark) 16.dp else 0.dp)
            .background(color = Color.White.copy(alpha = .9f), shape = RoundedCornerShape(100.dp))
    ) {
        Column(modifier = Modifier
            .padding(8.dp)
            .width(72.dp)) {
            Box(
                Modifier
                    .weight(1f)
                    .fillMaxSize()) {
                Text(
                    text = "0.0${StringConstants.CELSIUS}",
                    color = Color.Black,
                    modifier = Modifier.align(Alignment.Center),
                )
            };
            Box(
                Modifier
                    .weight(1f)
                    .fillMaxSize().background(color = Color.Blue.copy(alpha = .5f), shape = CircleShape,)) {
                Text(
                    text = "0.0${StringConstants.CELSIUS}",
                    color = Color.Black,
                    modifier = Modifier.align(Alignment.Center).padding(4.dp),
                )
            };
            Box(
                Modifier
                    .weight(1f)
                    .fillMaxSize()) {
                Text(
                    text = "0.0${StringConstants.CELSIUS}",
                    color = Color.Black,
                    modifier = Modifier.align(Alignment.Center),
                )
            };
        }
    }
}


enum class ForecastDay {
    TODAY, TOMORROW
}

@Composable
fun TodayTomorrowButton(
    modifier: Modifier = Modifier,
    selected: ForecastDay,
    forecastDay: ForecastDay,
    onSelect: (it: ForecastDay) -> Unit,
) {
    Column(horizontalAlignment = Alignment.CenterHorizontally, modifier = modifier) {
        Text(
            text = forecastDay.name.lowercase().replaceFirstChar { it.uppercase() },
            modifier = Modifier
                .padding(horizontal = 8.dp, vertical = 4.dp)
                .clickable { onSelect(forecastDay) },
        );
        if (selected == forecastDay) {
            Box(
                modifier = Modifier
                    .size(5.dp)
                    .background(
                        shape = CircleShape,
                        color = Color.White,
                    ),
            )
        }
    }
}