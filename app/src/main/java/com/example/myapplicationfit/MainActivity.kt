package com.example.myapplicationfit

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
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.myapplicationfit.ui.theme.MyApplicationFitTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationFitTheme {
                // State holders for email and password
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
                        Greeting(email)
                        Spacer(modifier = Modifier.height(16.dp))
                        TwoTextFields(
                            email = email,
                            onEmailChange = { email = it },
                            password = password,
                            onPasswordChange = { password = it }
                        )
                        CustomButton(onClick = { /* TODO: Add your logic here */ },
                            modifier = Modifier
                        )
                    }
                }
            }
        }
    }
}


@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello, $name!",
        modifier = modifier,
        fontWeight = FontWeight.Bold
    )
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


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MyApplicationFitTheme {
        Greeting("Camila")
    }
}
