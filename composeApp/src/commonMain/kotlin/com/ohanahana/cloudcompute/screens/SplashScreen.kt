package com.ohanahana.cloudcompute.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.ohanahana.cloudcompute.LoadImage
import com.ohanahana.cloudcompute.pretendardFontFamily
import kmp_app_template.composeapp.generated.resources.Res
import kmp_app_template.composeapp.generated.resources.ic_bus_stop
import kotlinx.coroutines.delay
import org.jetbrains.compose.resources.painterResource

@Composable
fun SplashScreen(navController: NavHostController) {
    LaunchedEffect(Unit) {
        delay(3000)
        navController.navigate("sensorData") {
            popUpTo("splash") { inclusive = true }
        }
    }
    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {
        LoadImage("bg_splash", "bg_splash", Modifier.fillMaxSize())

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {


            LoadImage("ic_logo", "logo")
            Spacer(modifier = Modifier.height(24.dp))

            Text(
                text = "오하나하나",
                style = TextStyle(
                    fontSize = 24.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = Color(0xFF42023C),
                    fontFamily = pretendardFontFamily
                ),
            )
        }
        Column(
            modifier = Modifier
                .fillMaxSize()
                .align(Alignment.BottomCenter),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Bottom
        ) {
            Image(
                painter = painterResource(Res.drawable.ic_bus_stop),
                contentDescription = "bus_stop",
                modifier = Modifier
                    .size(180.dp)
            )
            Spacer(modifier = Modifier.height(40.dp))
        }
    }
}
