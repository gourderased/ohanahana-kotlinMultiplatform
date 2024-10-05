package com.jetbrains.kmpapp

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.jetbrains.kmpapp.screens.SensorDataScreen
import com.jetbrains.kmpapp.screens.SensorDataViewModel
import com.jetbrains.kmpapp.screens.SplashScreen
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.koin.compose.viewmodel.koinViewModel

@Composable
@Preview
fun App() {

    MaterialTheme {
        Surface {
            val navController: NavHostController = rememberNavController()

            NavHost(
                navController = navController,
                startDestination = "splash",
            ) {
                composable("splash") {
                    SplashScreen(navController)
                }
                composable("sensorData") {
                    val viewModel: SensorDataViewModel = koinViewModel()
                    val sensorData by viewModel.sensorData.collectAsState()

                    sensorData?.let {
                        SensorDataScreen(it)
                    }
                }

            }
        }

    }
}