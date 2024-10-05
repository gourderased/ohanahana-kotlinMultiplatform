package com.jetbrains.kmpapp.data

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

// 혼잡도 데이터를 처리하는 리포지토리 클래스
class CongestionRepository(
    private val congestionApi: CongestionApi, // 혼잡도 API
) {
    private val scope = CoroutineScope(SupervisorJob())
    private val congestionData = MutableStateFlow<CongestionObject?>(null) // API 응답을 저장할 StateFlow

    // 초기화 함수: 스코프 내에서 데이터를 새로 고침
    fun initialize() {
        scope.launch {
            refresh()
        }
    }

    // 혼잡도 데이터를 새로 고침하여 StateFlow에 저장
    suspend fun refresh() {
        val data = congestionApi.getData() // API에서 데이터 가져오기
        congestionData.value = data // 가져온 데이터 저장
    }

    // 저장된 혼잡도 객체를 가져오는 함수
    fun getObject(): Flow<CongestionObject?> = congestionData // StateFlow를 통해 데이터 제공
}