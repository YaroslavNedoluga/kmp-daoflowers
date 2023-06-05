package com.daoflowers.android

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.daoflowers.android.ui.catalog.flower.FlowerTypesScreen
import com.daoflowers.android.ui.theme.AppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppTheme {
                FlowerTypesScreen()
            }
        }
    }
}
