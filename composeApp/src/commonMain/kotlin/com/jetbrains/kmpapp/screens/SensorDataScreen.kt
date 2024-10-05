package com.jetbrains.kmpapp.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.jetbrains.kmpapp.data.CongestionObject
import kmp_app_template.composeapp.generated.resources.Res
import kmp_app_template.composeapp.generated.resources.bg_splash
import org.jetbrains.compose.resources.painterResource
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun SensorDataScreen(sensorData: CongestionObject) {
    // Koin에서 ViewModel 가져오기
    val viewModel: SensorDataViewModel = koinViewModel()
    val sensorDataState = viewModel.sensorData.collectAsState() // 센서 데이터 상태를 수집

    Box(
        modifier = Modifier
            .fillMaxSize()
//            .background(
//                brush = Brush.verticalGradient(
//                    colors = listOf(
//                        Color(0xFFFFDADA),
//                        Color(0xFFFBFBFB)
//                    )
//                )
//    )

    ) {
//        Image(
//            painter = painterResource(Res.drawable.bg_splash), // 배경 이미지
//            contentDescription = "Background Image",
//            modifier = Modifier.fillMaxSize() // 이미지가 화면 전체를 채우도록 설정
//        )

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

            }
        }
    }

}