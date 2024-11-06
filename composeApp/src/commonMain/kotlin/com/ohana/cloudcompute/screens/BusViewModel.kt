package com.ohana.cloudcompute.screens

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ohana.cloudcompute.data.BusApi
import com.ohana.cloudcompute.data.BusData
import com.ohana.cloudcompute.data.BusStop
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch


class BusViewModel(private val busApi: BusApi) : ViewModel() {
    private val _busData = MutableStateFlow<BusData?>(null)
    val busData: StateFlow<BusData?> = _busData

    init {
        fetchBusData()
    }

    fun fetchBusData() {
        viewModelScope.launch {
            LoadingState.show()
            try {
                val data = busApi.getBusData()

                // 변환 로직 적용
                val processedData = data.copy(
                    shuttle = processBusStop(data.shuttle),
                    ddg = processBusStop(data.ddg),
                    yg = processBusStop(data.yg),
                    inhaFrontGate = processBusStop(data.inhaFrontGate)
                )

                _busData.value = processedData

                delay(2000)
            } catch (e: Exception) {
                e.printStackTrace()
            } finally {
                LoadingState.hide()
            }
        }
    }

    private fun processBusStop(busStop: BusStop): BusStop {
        val remainTimeText = formatRemainTimeText(busStop.remainTime)

        return busStop.copy(
            remainTimeText = remainTimeText
        )
    }

    private fun formatRemainTimeText(timeInSeconds: Int): String {
        val minutes = timeInSeconds / 60
        val seconds = timeInSeconds % 60

        return when {
            timeInSeconds <= 0 -> "곧 도착"
            minutes > 0 -> "${minutes}분 ${seconds}초"
            else -> "${seconds}초"
        }
    }
}