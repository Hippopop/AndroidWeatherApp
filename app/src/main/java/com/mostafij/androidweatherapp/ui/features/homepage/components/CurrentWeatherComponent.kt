package com.mostafij.androidweatherapp.ui.features.homepage.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.mostafij.androidweatherapp.constants.StringConstants
import com.mostafij.androidweatherapp.ui.components.AutoResizedText


@Composable
fun CurrentWeatherComponent(modifier: Modifier = Modifier) {
    Box(
        modifier
            .fillMaxSize()
            .background(color = MaterialTheme.colorScheme.background)
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.fillMaxSize(),
        ) {
            Row(
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(IntrinsicSize.Min)
                    .padding(top = 12.dp),
            ) {
                AsyncImage(
                    model = "https://img.icons8.com/?size=48&id=sS05BACA8dfZ&format=png",
                    contentDescription = "Translated description of what the image contains",
                    modifier = Modifier
                        .padding(horizontal = 16.dp)
                        .fillMaxHeight()
                        .aspectRatio(1f),
                );
                Column {
                    Text(
                        text = "Today",
                        style = MaterialTheme.typography.headlineSmall,
                        color = MaterialTheme.colorScheme.inversePrimary,
                    );
                    Text(
                        text = "Sun, 30 Jun",
                        style = MaterialTheme.typography.bodyLarge,
                        modifier = Modifier.padding(3.dp),
                    );
                }
            }
            Box(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxHeight()
                    .padding(24.dp)

            ) {
                AutoResizedText(
                    text = "23${StringConstants.CELSIUS}",
                    color = MaterialTheme.colorScheme.inversePrimary,
                    style = TextStyle(fontSize = 500.sp, textAlign = TextAlign.Center),
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(8.dp),
                )
            };
            Text(
                text = "Pahartali, Chittagong.",
                style = MaterialTheme.typography.bodyLarge,
                modifier = Modifier
                    .padding(vertical = 8.dp)
                    .padding(bottom = 12.dp),
            );
            Row(
                verticalAlignment = Alignment.Bottom,
                horizontalArrangement = Arrangement.SpaceAround,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(IntrinsicSize.Min)
                    .padding(horizontal = 20.dp, vertical = 10.dp)
                    .padding(bottom = 16.dp),
            ) {
                Text(
                    text = "Feels Like 25${StringConstants.CELSIUS}",
                    style = MaterialTheme.typography.bodyLarge,
                );
                Text(".", color = MaterialTheme.colorScheme.inversePrimary);
                Text(
                    text = "Sunset 10:00 AM",
                    style = MaterialTheme.typography.bodyLarge,
                );
            }
        }

    }
}