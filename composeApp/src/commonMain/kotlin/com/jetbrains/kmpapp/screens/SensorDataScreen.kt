package com.jetbrains.kmpapp.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.jetbrains.kmpapp.data.CongestionObject
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun SensorDataScreen(sensorData: CongestionObject) {
    // Koin에서 ViewModel 가져오기
    val viewModel: SensorDataViewModel = koinViewModel()
    val sensorData = viewModel.sensorData.collectAsState() // 센서 데이터 상태를 수집

    Column(modifier = Modifier.fillMaxSize()
        .background(Color.Blue)) {
        sensorData.value?.let { data ->
            Text(
                text = "센서 데이터",
                style = MaterialTheme.typography.h4
            )
            Text(
                text = "현재 위치: ${data.currentLocation}",
                style = MaterialTheme.typography.body1
            )
            Text(
                text = "현재 시간: ${data.currentDateTime}",
                style = MaterialTheme.typography.body1
            )
            Text(
                text = "혼잡도 상태: ${data.congestion}",
                style = MaterialTheme.typography.body1
            )
            Text(
                text = "예상 대기 시간: ${data.expectedWaitingTime}",
                style = MaterialTheme.typography.body1
            )
            Text(
                text = "예상 대기 인원 수: ${data.expectedWaitingPeople}",
                style = MaterialTheme.typography.body1
            )
        } ?: run {
            // 데이터 로딩 중 표시할 UI (로딩 스피너 등)
            Text("로딩 중...")
        }
    }
}