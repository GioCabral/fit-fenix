package com.example.myapplicationfit.ui.components

import com.example.myapplicationfit.data.Sport
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.material3.Text

@Composable
fun SportItem(sport: Sport, onItemClick: (Sport) -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .clickable { onItemClick(sport) },
    ) {
        Text(
            text = sport.name,
            modifier = Modifier.padding(16.dp),
        )
    }
}
