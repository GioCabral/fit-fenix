package com.example.myapplicationfit.ui.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun CustomButton(onClick: () -> Unit, modifier: Modifier = Modifier) {
    Button(
        onClick = {
            onClick()
        },
        modifier = modifier
            .fillMaxWidth()
            .padding(16.dp)
            .height(50.dp), // Set height to 50dp
        colors = ButtonDefaults.buttonColors(
            contentColor = Color.White,
            containerColor = Color.LightGray
        ),
        shape = MaterialTheme.shapes.medium
    ) {
        Text(text = "Login")
    }
}
