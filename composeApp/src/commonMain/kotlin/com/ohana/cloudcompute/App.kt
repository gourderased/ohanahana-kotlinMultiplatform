package com.ohana.cloudcompute

import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.ohana.cloudcompute.screens.ProjectInfoScreen
import com.ohana.cloudcompute.screens.SensorDataScreen
import com.ohana.cloudcompute.screens.SensorDataViewModel
import com.ohana.cloudcompute.screens.SplashScreen
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
                startDestination = "projectInfo",
            ) {
                composable("splash") {
                    SplashScreen(navController)
                }
                composable("sensorData") {
                    val viewModel: SensorDataViewModel = koinViewModel()
                    val sensorData by viewModel.sensorData.collectAsState()

                    sensorData?.let {
                        SensorDataScreen(it, navController)
                    }
                }
                composable("projectInfo") {
                    ProjectInfoScreen(navController)
                }

            }
        }

    }
}