package com.example.foodapi

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.foodapi.ui.FoodApp
import com.example.foodapi.ui.theme.FoodApiTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FoodApiTheme {
                // A surface container using the 'background' color from the theme
                FoodApp()
            }
        }
    }
}

