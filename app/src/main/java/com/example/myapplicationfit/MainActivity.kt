package com.example.myapplicationfit

import com.example.myapplicationfit.ui.components.SportItem
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.*
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import com.example.myapplicationfit.ui.theme.MyApplicationFitTheme
import androidx.activity.compose.BackHandler
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import generateRandomSports

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()

            MyApplicationFitTheme {
                NavHost(navController = navController, startDestination = "login") {
                    composable("login") {
                        // Pass navController to LoginScreen
                        LoginScreen(navController = navController)
                    }
                    composable("home"){
                        HomeScreen(navController = navController)
                    }
                }
            }

            // Handle back navigation with BackHandler
            BackHandler {
                if (navController.currentBackStackEntry?.destination?.route != "login") {
                    navController.navigateUp()
                } else {
                    // Handle back navigation or exit the app when on the login screen
                    // For example, you can show a dialog or exit the app
                    // Finish the app
                    finish()
                }
            }
        }
    }
}

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

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TwoTextFields(email: String,
                  onEmailChange: (String) -> Unit,
                  password: String,
                  onPasswordChange: (String) -> Unit) {
    Column(
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        TextField(
            value = email,
            onValueChange = onEmailChange,
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp),
            singleLine = true
        )
        TextField(
            value = password,
            onValueChange = onPasswordChange,
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp),
            singleLine = true,
            visualTransformation = PasswordVisualTransformation() // To hide the password
        )
    }
}

@Composable
fun LoginScreen(navController: NavHostController) {
    var email by remember { mutableStateOf("Email") }
    var password by remember { mutableStateOf("Password") }

    // A surface container using the 'background' color from the theme
    Surface(
        color = MaterialTheme.colorScheme.background
    ) {
        Column(
            modifier = Modifier
                .padding(16.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(16.dp))
            TwoTextFields(
                email = email,
                onEmailChange = { email = it },
                password = password,
                onPasswordChange = { password = it }
            )
            CustomButton(onClick = { navController.navigate("home") },
                modifier = Modifier
            )
        }
    }
}

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
        val sportsList = generateRandomSports(10)
        LazyColumn {
            itemsIndexed(sportsList) { _, sport ->
                SportItem(sport = sport)
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