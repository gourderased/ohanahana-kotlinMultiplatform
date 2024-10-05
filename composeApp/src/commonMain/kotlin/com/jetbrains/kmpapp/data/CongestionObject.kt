package com.jetbrains.kmpapp.data

import kotlinx.serialization.Serializable

@Serializable
data class CongestionObject(
    val currentLocation: String,      // 현재 위치 (예: "인하대학교")
    val currentDateTime: String,      // 현재 날짜와 시간 (예: "2024-09-28 11:36 PM")
    val congestion: String,            // 혼잡도 상태 (예: "CONGESTION")
    val expectedWaitingTime: String,   // 예상 대기 시간 (예: "10분")
    val expectedWaitingPeople: String  // 예상 대기 인원 수 (예: "35명")
)