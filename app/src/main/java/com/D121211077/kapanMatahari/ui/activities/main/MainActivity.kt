package com.D121211077.kapanMatahari.ui.activities.main

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.D121211077.kapanMatahari.data.models.SunInfo
import com.D121211077.kapanMatahari.ui.activities.detail.DetailActivity
import com.D121211077.kapanMatahari.ui.theme.D121211077KapanMatahariTheme

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            D121211077KapanMatahariTheme{
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Scaffold(
                        topBar = {
                            TopAppBar(
                                title = { Text(text = "Kapan Matahari?") },
                            )
                        },
                        floatingActionButton = {
                            FloatingActionButton(onClick = {}) {
                                Icon(Icons.Default.Add, contentDescription = "Add")
                            }
                        }
                    ) {
                        Column(modifier = Modifier.padding(it)) {
                            val mainViewModel: MainViewModel = viewModel(factory = MainViewModel.Factory)
                            ListTimeScreen(mainViewModel.mainUiState)
                        }
                    }
                }
            }
        }
    }

    @Composable
    private fun ListTimeScreen(mainUiState: MainUiState, modifier: Modifier = Modifier) {
        when(mainUiState) {
            is MainUiState.Success -> ListTime(mainUiState.time)
            is MainUiState.Error -> ErrorText()
            is MainUiState.Loading -> LoadingBar()
        }
    }

    @Composable
    private fun ErrorText() {
        Text(text = "ERROR")
    }

    @Composable
    fun LoadingBar() {
        Text(text = "SEDANG LOADING")
    }

    @Composable
    fun ListTime(sunInfo: SunInfo?) {
        sunInfo?.let {
            Button(onClick = {
                val intent = Intent(this@MainActivity, DetailActivity::class.java)
                intent.putExtra("results", it.sunrise)
                startActivity(intent)
            }) {
                Text("Show Sunrise Details")
            }

            Button(onClick = {
                val intent = Intent(this@MainActivity, DetailActivity::class.java)
                intent.putExtra("results", it.sunrise)
                startActivity(intent)
            }) {
                Text("Show Sunset Details")
            }

            Button(onClick = {
                val intent = Intent(this@MainActivity, DetailActivity::class.java)
                intent.putExtra("results", it.sunrise)
                startActivity(intent)
            }) {
                Text("Show Solar Noon Details")
            }
        }
    }

}
