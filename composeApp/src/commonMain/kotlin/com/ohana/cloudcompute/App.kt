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
import com.ohana.cloudcompute.screens.BusInfoScreen
import com.ohana.cloudcompute.screens.GlobalLoadingScreen
import com.ohana.cloudcompute.screens.projectinfo.MainFeatureScreen
import com.ohana.cloudcompute.screens.projectinfo.ProjectInfoScreen
import com.ohana.cloudcompute.screens.SensorDataScreen
import com.ohana.cloudcompute.screens.SensorDataViewModel
import com.ohana.cloudcompute.screens.SplashScreen
import com.ohana.cloudcompute.screens.projectinfo.CongestionCriteriaScreen
import com.ohana.cloudcompute.screens.projectinfo.ExpectedPeopleTimeScreen
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.koin.compose.viewmodel.koinViewModel

@Composable
@Preview
fun App() {

    MaterialTheme {
        Surface {
            val navController: NavHostController = rememberNavController()
            GlobalLoadingScreen()
            NavHost(
                navController = navController,
                startDestination = "expectedPeopleTime",
            ) {
                composable("mainFeature") {
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
                composable("mainFeature") {
                    MainFeatureScreen(navController)
                }
                composable("busInfo") {
                    BusInfoScreen(navController)
                }
                composable("congestionCriteria") {
                    CongestionCriteriaScreen(navController)
                }
                composable("expectedPeopleTime") {
                    ExpectedPeopleTimeScreen(navController)
                }
            }
        }

    }
}