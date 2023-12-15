package com.D121211077.kapanMatahari.ui.activities.detail

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

import com.D121211077.kapanMatahari.ui.theme.D121211077KapanMatahariTheme
import com.D121211077.kapanMatahari.data.models.SunInfo


class DetailActivity : ComponentActivity() {

    private var selectedNews: SunInfo? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        selectedNews = intent.getParcelableExtra("NEWS")
        setContent {
            D121211077KapanMatahariTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    DetailScreen()
                }
            }
        }
    }

    @Composable
    private fun DetailScreen() {
        LazyColumn {
            item {
                Text(text = selectedNews?.sunrise.toString())
                Text(text = selectedNews?.sunset.toString())
            }
        }
    }

}