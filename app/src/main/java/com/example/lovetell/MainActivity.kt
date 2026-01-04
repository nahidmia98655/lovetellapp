package com.example.lovetell

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.Surface
import com.example.lovetell.ui.theme.LoveTellTheme
import com.example.lovetell.ui.navigation.NavGraph

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LoveTellTheme {
                Surface {
                    NavGraph()
                }
            }
        }
    }
}
