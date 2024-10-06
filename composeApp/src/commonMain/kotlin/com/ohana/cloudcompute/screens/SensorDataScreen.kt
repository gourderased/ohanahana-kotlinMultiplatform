package com.ohana.cloudcompute.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import com.ohana.cloudcompute.LoadImage
import com.ohana.cloudcompute.data.CongestionObject
import kmp_app_template.composeapp.generated.resources.Res
import kmp_app_template.composeapp.generated.resources.bg_home_congestion
import org.jetbrains.compose.resources.painterResource
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun SensorDataScreen(sensorData: CongestionObject) {
    // Koin에서 ViewModel 가져오기
    val viewModel: SensorDataViewModel = koinViewModel()
    val sensorDataState = viewModel.sensorData.collectAsState() // 센서 데이터 상태를 수집

    Box(
        modifier = Modifier.fillMaxSize().border(2.dp, Color.Red)
//            .background(
//                brush = Brush.verticalGradient(
//                    colorStops = arrayOf(
//                        0.0f to Color(0xFFFFDADA),  // 상단의 연한 핑크색
//                        0.56f to Color(0xFFFBFBFB)
//                    )
//                )
//            )
    ) {
        Image(
            painter = painterResource(Res.drawable.bg_home_congestion),
            contentDescription = "test",
            modifier = Modifier
                .fillMaxSize(),
            contentScale = ContentScale.Crop
        )

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 24.dp)
                .padding(top = 48.dp)

        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                LoadImage("ic_logo", "logo", Modifier)

                LoadImage("ic_refresh", "refresh", Modifier)
            }
        }
    }

}