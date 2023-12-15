package com.D121211077.kapanMatahari.ui.activities.detail

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.ui.Modifier
import com.D121211077.kapanMatahari.data.models.SunInfo
import com.D121211077.kapanMatahari.ui.theme.D121211077KapanMatahariTheme

class DetailActivity : ComponentActivity() {

    private var sunInfoValue: String? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        sunInfoValue = intent.getStringExtra("sunInfoValue")

        setContent {
            D121211077KapanMatahariTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Column {
                        Text(text = sunInfoValue ?: "No data")
                    }
                }
            }
        }
    }
}
