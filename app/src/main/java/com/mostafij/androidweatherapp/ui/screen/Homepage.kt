package com.mostafij.androidweatherapp.ui.screen

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ShoppingCart
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.mostafij.androidweatherapp.ui.viewmodel.WeatherDataViewModel

@Composable
fun Homepage(modifier: Modifier = Modifier, viewModel: WeatherDataViewModel) {
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
                Text(text = "Hello Android!", modifier = modifier)
            }
            IconButton(onClick = { /*TODO*/ }, modifier =  Modifier.padding(8.dp),) {
                Icon(

                    contentDescription = "Search Button",
                    imageVector = Icons.Rounded.ShoppingCart,
                )
            }
        }
    }
}