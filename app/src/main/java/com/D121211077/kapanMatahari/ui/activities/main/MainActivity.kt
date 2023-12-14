package com.D121211077.kapanMatahari.ui.activities.main

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import com.D121211077.kapanMatahari.ui.theme.D121211077KapanMatahariTheme

class MainActivity : ComponentActivity() {
    private val viewModel: TimeViewModel by viewModels()

    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            D121211077KapanMatahariTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Column {
                        val latitude = remember { mutableStateOf("") }
                        val longitude = remember { mutableStateOf("") }

                        TextField(
                            value = latitude.value,
                            onValueChange = { latitude.value = it },
                            label = { Text("Latitude") }
                        )

                        TextField(
                            value = longitude.value,
                            onValueChange = { longitude.value = it },
                            label = { Text("Longitude") }
                        )

                        viewModel.getTime(latitude.value, longitude.value)
                        SunriseSunset(
                            sunriseTime = viewModel.sunriseTime.collectAsState().value,
                            sunsetTime = viewModel.sunsetTime.collectAsState().value
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun SunriseSunset(sunriseTime: String?, sunsetTime: String?, modifier: Modifier = Modifier) {
    Text(
        text = "Sunrise: $sunriseTime, Sunset: $sunsetTime",
        modifier = modifier
    )
}