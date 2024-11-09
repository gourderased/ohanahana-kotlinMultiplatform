package com.ohanahana.cloudcompute

import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.ohanahana.cloudcompute.screens.BusInfoScreen
import com.ohanahana.cloudcompute.screens.GlobalLoadingScreen
import com.ohanahana.cloudcompute.screens.projectinfo.MainFeatureScreen
import com.ohanahana.cloudcompute.screens.projectinfo.ProjectInfoScreen
import com.ohanahana.cloudcompute.screens.SensorDataScreen
import com.ohanahana.cloudcompute.screens.SplashScreen
import com.ohanahana.cloudcompute.screens.projectinfo.CongestionCriteriaScreen
import com.ohanahana.cloudcompute.screens.projectinfo.ExpectedPeopleTimeScreen
import com.ohanahana.cloudcompute.screens.projectinfo.SensorOperationTimeScreen
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
@Preview
fun App() {

    MaterialTheme {
        Surface {
            val navController: NavHostController = rememberNavController()
            GlobalLoadingScreen()
            NavHost(
                navController = navController,
                startDestination = "splash",
            ) {
                composable("splash") {
                    SplashScreen(navController)
                }
                composable("sensorData") {
                    SensorDataScreen(navController)
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
                composable("sensorOperationTime") {
                    SensorOperationTimeScreen(navController)
                }
            }
        }

    }
}