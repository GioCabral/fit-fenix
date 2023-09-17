package com.example.myapplicationfit.ui.sport

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.myapplicationfit.data.getSportById
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@Composable
fun SportDetailScreen(navController: NavHostController, sportId: Int) {
    val sport = getSportById(sportId)

    var elapsedTime by remember { mutableIntStateOf(0) }
    var isRunning by remember { mutableStateOf(false) }

    val coroutineScope = rememberCoroutineScope()

    val startTimer = {
        coroutineScope.launch {
            isRunning = true
            while (isRunning) {
                delay(1000)
                elapsedTime++
            }
        }
    }

    val stopTimer = {
        isRunning = false
    }

    val resetTimer = {
        elapsedTime = 0
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Sport Detail",
            fontSize = 24.sp,
        )

        Spacer(modifier = Modifier.height(16.dp))

        if (sport != null) {
            Text(
                text = "Sport Name: ${sport.name}",
                fontSize = 18.sp,
            )
        }

        Text(
            text = "Elapsed Time: $elapsedTime seconds",
            fontSize = 20.sp,
        )

        // Start, Stop, and Reset buttons
        Row(
            modifier = Modifier.padding(8.dp),
            horizontalArrangement = Arrangement.Center
        ) {
            Button(
                onClick = {
                    if (isRunning) {
                        stopTimer()
                    } else {
                        startTimer()
                    }
                },
                modifier = Modifier.padding(8.dp)
            ) {
                Text(text = if (isRunning) "Stop" else "Start")
            }

            Button(
                onClick = {
                    resetTimer()
                },
                modifier = Modifier.padding(8.dp)
            ) {
                Text(text = "Reset")
            }
        }

        Button(
            onClick = {
                navController.navigate("home")
            },
            modifier = Modifier.padding(8.dp)
        ) {
            Text(text = "Back to Home")
        }
    }
}
