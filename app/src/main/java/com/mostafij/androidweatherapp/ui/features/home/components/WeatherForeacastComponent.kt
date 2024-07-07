package com.mostafij.androidweatherapp.ui.features.home.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
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


@Composable
fun WeatherForecastComponent(modifier: Modifier = Modifier, navigateToForecastDay: () -> Unit) {
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
                    .padding(horizontal = 32.dp, vertical = 8.dp)
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
                    modifier = Modifier.clickable { navigateToForecastDay() }) {
                    Text(
                        text = "Next 7 days",
                        color = MaterialTheme.colorScheme.primaryContainer,
                        style = MaterialTheme.typography.titleLarge,
                    );
                    Icon(
                        painter = painterResource(id = R.drawable.arrowhead_right),
                        contentDescription = "Search Button",
                        tint = MaterialTheme.colorScheme.primaryContainer,
                        modifier = Modifier
                            .size(20.dp)
                            .padding(start = 3.dp)
                    );

                }
            }
            LazyRow(
                contentPadding = PaddingValues(horizontal = 6.dp),
                modifier = Modifier
                    .weight(55f)
                    .fillMaxHeight()
                    .padding(top = 8.dp, bottom = 8.dp)
                    .padding(vertical = 10.dp),
            ) {
                items(10) {
                    HourlyForecastComponent(isDark = (it.mod(2) == 0))
                }
            }
            ChanceOfRainComponent(modifier = Modifier.weight(45f));
        }
    }
}


@Composable
fun ChanceOfRainComponent(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(top = 10.dp)
            .padding(horizontal = 24.dp),
    ) {
        Text(
            text = "Chance of Rain",
            color = MaterialTheme.colorScheme.inversePrimary,
            style = MaterialTheme.typography.titleLarge,
            modifier = Modifier.padding(bottom = 8.dp),
        );
        Row(modifier = Modifier
            .weight(1f)
            .padding(bottom = 8.dp)) {
            Column(Modifier.padding(end = 3.dp, bottom = 14.dp)) {
                val days = listOf("Sunny", "Rainy", "Heavy Rain");
                days.forEach {
                    Box(Modifier.weight(1f)) {
                        Text(
                            text = it,
                            modifier = Modifier.align(Alignment.Center),
                        )
                    };
                }
            };
            LazyRow(
                Modifier
                    .weight(1f)
                    .padding(horizontal = 4.dp),
                contentPadding = PaddingValues(4.dp),
            ) {
                items(10) {
                    HourlyRainMeterComponent(
                        rainPercentage = (it * 10).toFloat()
                    )
                }
            }
        }
    }
}


@Composable
fun HourlyRainMeterComponent(modifier: Modifier = Modifier, rainPercentage: Float) {
    Column(
        modifier.padding(horizontal = 4.dp), horizontalAlignment = Alignment.CenterHorizontally
    ) {
        BoxWithConstraints(
            modifier = Modifier
                .weight(1f)
                .width(8.dp)
                .padding(vertical = 4.dp)
                .background(
                    color = MaterialTheme.colorScheme.secondary.copy(alpha = .30f),
                    shape = RoundedCornerShape(8.dp),
                ),
        ) {
            Box(
                modifier = Modifier
                    .width(8.dp)
                    .height((constraints.maxHeight * rainPercentage).dp)
                    .align(Alignment.BottomCenter)
                    .background(
                        color = Color.Yellow,
                        shape = RoundedCornerShape(8.dp),
                    ),
            ) {

            }
        }
        Text(text = "${3 + 1} AM");
    }
}


