package com.example.myapplicationfit

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import com.example.myapplicationfit.ui.theme.MyApplicationFitTheme
import androidx.activity.compose.BackHandler
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.compose.foundation.layout.*
import androidx.navigation.NavType
import androidx.navigation.navArgument
import com.example.myapplicationfit.data.getSportById
import com.example.myapplicationfit.ui.home.HomeScreen
import com.example.myapplicationfit.ui.login.LoginScreen
import com.example.myapplicationfit.ui.sport.SportDetailScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()

            MyApplicationFitTheme {
                NavHost(navController = navController, startDestination = "login") {
                    composable("login") {
                        LoginScreen(navController = navController)
                    }
                    composable("home"){
                        HomeScreen(navController = navController)
                    }
                    composable(
                        "sportDetail/{sportId}",
                        arguments = listOf(navArgument("sportId") { type = NavType.IntType })
                    ) { backStackEntry ->
                        val sportId = backStackEntry.arguments?.getInt("sportId")
                        if (sportId != null) {
                            SportDetailScreen(navController = navController, sportId = sportId)
                        } else {
                            // Handle the case where the sport with the given ID is not found
                        }
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