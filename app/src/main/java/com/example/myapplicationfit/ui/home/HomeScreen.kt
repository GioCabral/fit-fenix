package com.example.myapplicationfit.ui.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.myapplicationfit.ui.components.SportItem
import com.example.myapplicationfit.data.generateHardCodedSports
@Composable
fun HomeScreen(navController: NavHostController) {
    Column(
        modifier = Modifier
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Welcome to the Home Screen!",
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Display the list of sports in a LazyColumn
        val sportsList = generateHardCodedSports()
        LazyColumn {
            itemsIndexed(sportsList) { _, sport ->
                SportItem(sport = sport) { clickedSport ->
                    // Navigate to the sport detail page here using navController
                    navController.navigate("sportDetail/${clickedSport.id}")
                }
            }
        }


        Button(
            onClick = {
                navController.navigate("login")
            },
            modifier = Modifier.padding(8.dp)
        ) {
            Text(text = "Logout")
        }
    }
}