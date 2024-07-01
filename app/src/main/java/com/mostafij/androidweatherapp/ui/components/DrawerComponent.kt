package com.mostafij.androidweatherapp.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp


@Composable
fun DrawerSection(modifier: Modifier = Modifier) {
    ModalDrawerSheet {
        Box(
            modifier
                .fillMaxWidth()
                .height(300.dp)
                .background(color = MaterialTheme.colorScheme.background),
        ) {
            Text(
                "Drawer title", modifier = Modifier.padding(16.dp),
            )
        }
        HorizontalDivider()
        NavigationDrawerItem(
            label = { Text(text = "Drawer Item") },
            selected = false,
            onClick = { /*TODO*/ },
        )
    }
}