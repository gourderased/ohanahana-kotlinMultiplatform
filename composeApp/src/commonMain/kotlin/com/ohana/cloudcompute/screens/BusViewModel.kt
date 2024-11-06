package com.ohana.cloudcompute.screens

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ohana.cloudcompute.data.BusApi
import com.ohana.cloudcompute.data.BusData
import com.ohana.cloudcompute.data.BusStop
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.isActive
import kotlinx.coroutines.launch
import kotlinx.datetime.Clock

class BusViewModel(private val busApi: BusApi) : ViewModel() {
    private val _busData = MutableStateFlow<BusData?>(null)
    val busData: StateFlow<BusData?> = _busData

    private var dataFetchTime: Long = 0L
    private var timerJob: Job? = null

    init {
        fetchBusData()
    }

    fun fetchBusData() {
        viewModelScope.launch {
            LoadingState.show()
            try {
                val currentTimeMillis = Clock.System.now().toEpochMilliseconds()
                val elapsedTimeSinceLastFetch = (currentTimeMillis - dataFetchTime) / 1000 // 초 단위

                if (elapsedTimeSinceLastFetch < 30 && _busData.value != null) {
                    // 30초가 지나지 않았고, 기존 데이터가 있는 경우
                } else {
                    // 30초가 지났거나, 기존 데이터가 없는 경우
                    val data = busApi.getBusData()

                    // 데이터 받은 시간 저장
                    dataFetchTime = currentTimeMillis

                    // 변환 로직 적용
                    val processedData = data.copy(
                        shuttle = processBusStop(data.shuttle),
                        ddg = processBusStop(data.ddg),
                        yg = processBusStop(data.yg),
                        inhaFrontGate = processBusStop(data.inhaFrontGate)
                    )

                    _busData.value = processedData

                    // 타이머 시작 또는 재시작
                    startTimer()
                }

                // 필요에 따라 추가 로직 작성
            } catch (e: Exception) {
                e.printStackTrace()
            } finally {
                delay(2000)
                LoadingState.hide()
            }
        }
    }

    private fun processBusStop(busStop: BusStop): BusStop {
        return busStop.copy(
            initialRemainTime = busStop.remainTime
        )
    }

    private fun startTimer() {
        // 기존 타이머 취소
        timerJob?.cancel()

        timerJob = viewModelScope.launch(Dispatchers.Default) {
            while (isActive) {
                // 1초마다 업데이트
                delay(1000)

                _busData.update { busData ->
                    busData?.copy(
                        shuttle = updateBusStop(busData.shuttle),
                        ddg = updateBusStop(busData.ddg),
                        yg = updateBusStop(busData.yg),
                        inhaFrontGate = updateBusStop(busData.inhaFrontGate)
                    )
                }
            }
        }
    }

    private fun updateBusStop(busStop: BusStop): BusStop {
        val currentTimeMillis = Clock.System.now().toEpochMilliseconds()
        val elapsedTimeInSeconds = ((currentTimeMillis - dataFetchTime) / 1000).toInt()

        val remainingTimeInSeconds = if (busStop.initialRemainTime == -1) {
            -1
        } else {
            busStop.initialRemainTime - elapsedTimeInSeconds
        }

        val remainTimeText = formatRemainTimeText(remainingTimeInSeconds)

        return busStop.copy(
            remainTimeText = remainTimeText
        )
    }

    private fun formatRemainTimeText(timeInSeconds: Int): String {
        if (timeInSeconds == -1) {
            return "정보없음"
        }

        val adjustedTimeInSeconds = if (timeInSeconds < 0) 0 else timeInSeconds

        val minutes = adjustedTimeInSeconds / 60
        val seconds = adjustedTimeInSeconds % 60

        return when {
            adjustedTimeInSeconds <= 0 -> "곧 도착"
            minutes > 0 -> "${minutes}분 ${seconds}초"
            else -> "${seconds}초"
        }
    }

    override fun onCleared() {
        super.onCleared()
        timerJob?.cancel()
    }
}